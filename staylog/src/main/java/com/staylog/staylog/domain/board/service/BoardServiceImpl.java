package com.staylog.staylog.domain.board.service;

import com.staylog.staylog.domain.board.dto.BoardDto;
import com.staylog.staylog.domain.board.dto.request.BoardListRequest;
import com.staylog.staylog.domain.board.dto.response.BoardListResponse;
import com.staylog.staylog.domain.board.mapper.BoardMapper;
import com.staylog.staylog.global.common.dto.PageRequest;
import com.staylog.staylog.global.common.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;



    @Override
    public BoardListResponse getByBoardType(BoardListRequest request, PageRequest pageRequest) {

        String boardType = request.getBoardType();

        // 게시글 목록 조회 (검색조건) _추가예정
        List<BoardDto> boardList = boardMapper.getByBoardType(request);


        // 검색 쿼리 문자열 조합

        // 전체 게시글 수 조회
        int totalCount = boardMapper.countByBoardType(request);

        // 페이지 계산
        PageResponse pageResponse = new PageResponse();
        pageResponse.calculate(pageRequest, totalCount);


        // 응답 DTO (builder)
        return BoardListResponse.builder()
                .boardList(boardList)
                .boardType(request.getBoardType())
                .keyword(request.getKeyword())
                .search(request.getSearch())
                .query(request.getSearch())
                .pageResponse(pageResponse)
                .build();
    }



    @Override
    public void insert(BoardDto boardDto) {



    }

    @Override
    public void update(BoardDto boardDto) {

    }

    @Override
    public void delete(BoardDto boardDto) {

    }
}
