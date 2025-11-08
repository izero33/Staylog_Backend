package com.staylog.staylog.domain.common.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.staylog.staylog.domain.common.mapper.SequenceMapper;
import com.staylog.staylog.domain.common.service.SequenceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SequenceServiceImpl implements SequenceService{

	private final SequenceMapper sequenceMapper;
	
	@Override
	public Long getNextIdForTable(String tableName) {
		// 프론트에서 받은 테이블 이름을 기반으로 시퀀스 이름을 조립 (e.g., "BOARD" -> "SEQ_BOARD_ID")
		String sequenceName = "SEQ_" + tableName.toUpperCase() + "_ID";
		log.info("ID 발급 요청. Table: , Sequence: ", tableName, sequenceName);
		return sequenceMapper.getNextVal(sequenceName);
	}

}
