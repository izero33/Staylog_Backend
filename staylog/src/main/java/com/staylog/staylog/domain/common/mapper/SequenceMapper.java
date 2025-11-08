package com.staylog.staylog.domain.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SequenceMapper {
	/**
	 * 주어진 시퀀스 이름으로 다음 시퀀스 값을 조회
	 * @param sequenceName 조회할 시퀀스 이름
	 * @return 생성된 다음 시퀀스 값
	 */
	Long getNextVal(@Param("sequenceName") String sequenceName);
}
