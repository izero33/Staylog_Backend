package com.staylog.staylog.domain.home.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.staylog.staylog.domain.home.dto.response.HomeAccommodationListResponse;

@Mapper
public interface HomeMapper {
	
	List<HomeAccommodationListResponse> selectAccommodationMain(
			@Param("regionCode") String regionCode, //지역코드
			@Param("sort") String sort,//별점 순(rating), 리뷰 개수 순(review), 최신 등록 순(latest)
			@Param("offset") int offset, //몇개 건너뛰고 가져올지
			@Param("limit") int limit //한번에 몇개 가져올 지
			
			);
	
	//최신순
	List<HomeAccommodationListResponse> selectAccommodationByLatest(
			@Param("regionCode") String regionCode,
			@Param("offset") int offset,
			@Param("limit") int limit
	);
	
	//최저가순
	List<HomeAccommodationListResponse> selectAccommodationByPrice(
			@Param("regionCode") String regionCode,
			@Param("offset") int offset,
			@Param("limit") int limit
	);
	
	//별점순
	List<HomeAccommodationListResponse> selectAccommodationByRating(
			@Param("regionCode") String regionCode,
			@Param("offset") int offset,
			@Param("limit") int limit
	);
	
	//리뷰많은 순
		List<HomeAccommodationListResponse> selectAccommodationByReview(
				@Param("regionCode") String regionCode,
				@Param("offset") int offset,
				@Param("limit") int limit
		);
}
