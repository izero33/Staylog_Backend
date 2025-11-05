package com.staylog.staylog.domain.admin.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.staylog.staylog.domain.admin.board.dto.AdminBoardSearchRequest;
import com.staylog.staylog.domain.admin.board.dto.AdminBoardStatusRequest;
import com.staylog.staylog.domain.admin.board.mapper.AdminBoardMapper;
import com.staylog.staylog.domain.admin.board.service.AdminBoardService;
import com.staylog.staylog.domain.board.dto.BoardDto;
import com.staylog.staylog.global.common.response.PageResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 관리자 게시글 관리 서비스 구현체
 * 게시글의 삭제/복원, 조회 기능을 제공합니다.
 *
 * @author 천승현
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AdminBoardServiceImpl implements AdminBoardService{
	
	private final AdminBoardMapper mapper;
	
    /**
     * 게시글 목록 조회
     * @param BoardSearchDto 검색 조건 (게시글타입, 키워드, 삭제여부, 정렬조건)
     * @return 게시글 목록
     */
	@Override
	public Map<String, Object> selectBoardList(AdminBoardSearchRequest searchRequest) {
		
		//게시글 목록 조회
        List<BoardDto> boards = mapper.selectBoardList(searchRequest);
        
        //전체 게시글 수 조회
        int totalCount = mapper.countBoardList(searchRequest);
        
        //페이지 정보 계산
        PageResponse pageResponse = new PageResponse();
        pageResponse.calculate(searchRequest, totalCount);
        
        //결과를 Map 에 담아 반환
        Map<String, Object> result = new HashMap<>();
        result.put("boards", boards);
        result.put("page", pageResponse);
        
        log.info("게시글 목록 조회 완료 - 총 {}건, 현재 페이지: {}/{}", 
                 totalCount, searchRequest.getPageNum(), pageResponse.getTotalPage());
        
        return result;
    }
	
	
    /**
     * 게시글 상세 조회
     * @param boardId 게시글 ID
     * @return 게시글 상세 정보
     */
	@Override
	public BoardDto selectBoardDetail(Long boardId) {
		
		return mapper.selectBoardDetail(boardId);
	}
	
    /**
     * 게시글 상태전환 (삭제/복원)
     * @param request 게시글 상태 변경 요청 DTO (boardId, deletedYn 포함)
     * @return 삭제된 행 수
     */
	@Override
	public void updateBoardStatus(AdminBoardStatusRequest request) {
		
		mapper.updateBoardStatus(request);
	}
}
