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
	long selectMaxDisplayOrder(String targetType, long targetId);
	List<ImageDto> selectImagesByTarget(String targetType, long targetId);
	ImageDto selectProfileByUserId(String targetType, @Param("targetId") long userId);

	//정나영 : 보드 아이디만(타겟 아이디)만
	Long getNextBoardId();
	
	Long selectForUpdate(Map<String, Object> params);
	void updateCounter(Map<String, Object> params);
	void createCounter(Map<String, Object> params);
}