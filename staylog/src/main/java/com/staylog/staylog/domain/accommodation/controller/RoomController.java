package com.staylog.staylog.domain.accommodation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staylog.staylog.domain.accommodation.dto.response.RoomDetailResponse;
import com.staylog.staylog.domain.accommodation.service.RoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomController {

	private final RoomService roomService;
	
	@GetMapping("/room/{roomId}")
	public RoomDetailResponse detailRoom(@PathVariable long roomId) {
		return roomService.roomDetail(roomId);
	}
		
	
}
