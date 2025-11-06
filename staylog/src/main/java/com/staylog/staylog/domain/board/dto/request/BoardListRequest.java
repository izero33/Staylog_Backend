package com.staylog.staylog.domain.board.dto.request;

import com.staylog.staylog.global.common.dto.PageRequest;
import lombok.*;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("BoardListRequest")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardListRequest extends PageRequest {

    private String boardType;   // 게시판 카테고리

    private List<String> regionCodes;  // 지역 코드 (다중선택)

    private String sort;
    private String keyword;     // 검색어
    private String search;      // 검색 조건 (title, content,,)



}
