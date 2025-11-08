package com.staylog.staylog.domain.common.service;

public interface SequenceService {
	/**
	 * 테이블 이름을 기반으로 다음 PK ID를 가져옵니다.
	 * @param tableName ID를 생성할 테이블의 이름 (e.g., "BOARD", "ACCOMMODATION")
	 * @return 생성된 다음 ID 값
	 */
	Long getNextIdForTable(String tableName);
}
