package com.staylog.staylog.domain.common.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staylog.staylog.domain.common.service.SequenceService;
import com.staylog.staylog.global.common.code.SuccessCode;
import com.staylog.staylog.global.common.response.SuccessResponse;
import com.staylog.staylog.global.common.util.MessageUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "ID Draft 컨트롤러", description = "공용 ID 사전 발급")
@RestController
@RequestMapping("/v1/common")
@RequiredArgsConstructor
public class SequenceController {

	private final SequenceService sequenceService;
	private final MessageUtil messageUtil;
	
	@Operation(summary = "테이블 PK ID 사전 발급", description = "테이블 이름을 기반으로 다음 ID를 미리 발급받습니다.")
	@PostMapping("/draft/{tableName}")
	ResponseEntity<SuccessResponse<Long>> getDraftId(@PathVariable String tableName) {
		Long nextId = sequenceService.getNextIdForTable(tableName);

        String message = messageUtil.getMessage(SuccessCode.SUCCESS.getMessageKey());
        String code = SuccessCode.SUCCESS.getCode();

        SuccessResponse<Long> success = SuccessResponse.of(code, message, nextId);

        return ResponseEntity.ok(success);
	}
}
