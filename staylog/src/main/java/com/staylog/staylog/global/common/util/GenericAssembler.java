package com.staylog.staylog.global.common.util;

import com.staylog.staylog.domain.image.dto.ImageData;
import com.staylog.staylog.domain.image.dto.ImageResponse;
import com.staylog.staylog.domain.image.service.ImageService;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericAssembler {

    /**
     * 메인 데이터 목록에 이미지 정보를 조합하는 범용 메서드.
     *
     * @param mainDataList 메인 데이터 목록 (e.g., List<AdminAccommodationDetailResponse>)
     * @param idExtractor  메인 데이터에서 targetId를 추출하는 함수 (e.g., AdminAccommodationDetailResponse::getAccommodationId)
     * @param imageSetter  메인 데이터에 이미지 목록을 설정하는 BiConsumer (e.g., (dto, images) -> dto.setImages(images))
     * @param imageService ImageService 인스턴스
     * @param targetType   이미지를 조회할 targetType (e.g., "ACCOMMODATION")
     * @param <T>          메인 데이터의 타입
     */
    public static <T> void assembleImages(
            List<T> mainDataList,
            Function<T, Long> idExtractor,
            BiConsumer<T, List<ImageData>> imageSetter,
            ImageService imageService,
            String targetType) {

        if (mainDataList == null || mainDataList.isEmpty()) {
            return;
        }

        // 1. 메인 데이터 목록에서 Long 타입의 ID 목록을 추출합니다.
        List<Long> targetIds = mainDataList.stream()
                .map(idExtractor)
                .filter(java.util.Objects::nonNull) // null ID는 필터링
                .collect(Collectors.toList());

        // ID가 없으면 이미지 조회 불필요
        if (targetIds.isEmpty()) {
            mainDataList.forEach(data -> imageSetter.accept(data, java.util.Collections.emptyList()));
            return;
        }

        // 2. ID 목록을 사용하여 이미지 정보를 한 번의 쿼리로 가져옵니다.
        //    결과는 Map<Long, ImageResponse> 형태로 받습니다.
        Map<Long, ImageResponse> imageMap = imageService.getImagesByTargets(targetType, targetIds);

        // 3. 메인 데이터 목록을 순회하며 각 데이터에 맞는 이미지 정보를 설정합니다.
        mainDataList.forEach(data -> {
            Long id = idExtractor.apply(data);
            if (id != null) {
                ImageResponse images = imageMap.get(id);
                if (images != null && images.getImages() != null) {
                    imageSetter.accept(data, images.getImages());
                } else {
                    imageSetter.accept(data, java.util.Collections.emptyList()); // 이미지가 없으면 빈 리스트 설정
                }
            } else {
                imageSetter.accept(data, java.util.Collections.emptyList()); // ID가 없으면 빈 리스트 설정
            }
        });
    }
}
