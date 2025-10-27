package com.staylog.staylog.domain.accommodation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.staylog.staylog.domain.accommodation.dto.response.RoomDetailResponse;

@Mapper
public interface RoomMapper {
	RoomDetailResponse selectRoomDetailById(@Param("roomId") Long roomId);
}
