package com.staylog.staylog.domain.board.mapper;

import com.staylog.staylog.domain.board.dto.BoardDto;
import com.staylog.staylog.domain.board.dto.request.BoardListRequest;

import java.util.List;

public interface BoardMapper {

    List<BoardDto> getByBoardType(BoardListRequest request);
    void insert(BoardDto boardDto);
    void update(BoardDto boardDto);
    void delete(BoardDto boardDto);

    int countByBoardType(BoardListRequest request);


}
