package com.staylog.staylog.domain.accommodation.service;

import com.staylog.staylog.domain.accommodation.dto.response.RoomDetailResponse;

public interface RoomService {

	RoomDetailResponse roomDetail(long roomId);
}
