package com.staylog.staylog.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * 지역관련 Dto
 *
 * 미사용 !!!
 *
 * ----- enum(Region) 으로 처리할 예정 -----
 *
 * @author 김지은
 */

@Getter
@Setter
public class RegionDto {

    private Long region_id;     // 지역 고유번호 (PK)
    private String region_name; // 지역명
    private Long parent_id;     // 상위 지역 고유번호 (NULL 가능)
    private String field;       // 정렬순서 기준 (정의/설명용)
}
