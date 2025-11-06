package com.staylog.staylog.domain.image.mapper;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param; // Import Param annotation

import com.staylog.staylog.domain.image.dto.ImageDto;

import java.util.List;
import java.util.Map;

@Mapper
public interface ImageMapper {
	void insertImage(ImageDto imageDto);
	/**
	 * @deprecated 동시성 문제로 더이상 사용하지 않음
	 */
	Long selectMaxDisplayOrder(String targetType, Long targetId);
	List<ImageDto> selectImagesByTarget(String targetType, Long targetId);
	ImageDto selectProfileByUserId(String targetType, @Param("targetId") Long userId);

	//정나영 : 보드 아이디만(타겟 아이디)만
	Long getNextBoardId();
	
	/**
	 * 이미지 카운터를 Upsert(있으면 증가, 없으면 생성)하고 현재 카운터 값을 반환.
	 * @param params targetType, targetId를 담은 Map. next_display_order 값이 이 맵에 채워짐.
	 * @return 업데이트된 행의 수 (실제로는 사용하지 않음)
	 */
	long upsertAndGetCounter(Map<String, Object> params);
}