package com.staylog.staylog.domain.board.service;

import com.staylog.staylog.domain.board.dto.BoardDto;

import com.staylog.staylog.domain.board.dto.BookingDto;
import com.staylog.staylog.domain.board.dto.response.BoardListResponse;
import com.staylog.staylog.domain.board.mapper.BoardMapper;
import com.staylog.staylog.global.common.code.ErrorCode;
import com.staylog.staylog.global.common.dto.PageRequest;
import com.staylog.staylog.global.common.response.PageResponse;
import com.staylog.staylog.global.event.ReviewCreatedEvent;
import com.staylog.staylog.global.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private final ApplicationEventPublisher eventPublisher;


    @Override
    public BoardListResponse getByBoardType(BoardDto boardDto, PageRequest pageRequest) {

        // 전체 게시글 수
        int totalCount = boardMapper.countByBoardType(boardDto.getBoardType());


        // 게시글 목록
        List<BoardDto> boardList = boardMapper.getByBoardType(boardDto.getBoardType());

        // 페이지 계산 결과
        PageResponse pageResponse = new PageResponse();
        pageResponse.calculate(pageRequest, totalCount);

        // 4️⃣ BoardListResponse로 묶어서 반환
        return BoardListResponse.builder()
                .boardList(boardList)
                .pageResponse(pageResponse)
                .build();

    }

    @Override
    public BoardDto getByBoardId(long boardId) {

        return boardMapper.getByBoardId(boardId);
    }


    @Override
    @Transactional
    public void insert(BoardDto boardDto) {

        boardMapper.insert(boardDto);

        // ============ 게시글 작성 이벤트 발행 (알림에서 사용) ============

        String boardType = boardDto.getBoardType();
        if(boardType.equals("BOARD_REVIEW")) { // 리뷰 게시글 이벤트만 발행
            ReviewCreatedEvent event = new ReviewCreatedEvent(boardDto.getBoardId(), boardDto.getAccommodationId(), boardDto.getBoardId(), boardDto.getUserId());
            eventPublisher.publishEvent(event);
        }

    }

    @Override
    public void update(BoardDto boardDto) {

        boardMapper.update(boardDto);

    }

    @Override
    public void delete(long boardId) {

        boardMapper.delete(boardId);

    }

    @Override
    public List<BookingDto> bookingList(long userId) {

        return boardMapper.bookingList(userId);
    }




}
