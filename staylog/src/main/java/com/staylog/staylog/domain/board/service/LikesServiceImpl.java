package com.staylog.staylog.domain.board.service;


import com.staylog.staylog.domain.board.dto.LikesDto;
import com.staylog.staylog.domain.board.mapper.LikesMapper;
import com.staylog.staylog.global.common.code.ErrorCode;
import com.staylog.staylog.global.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikesServiceImpl implements LikesService {

    private final LikesMapper likesMapper;

    @Override
    public List<LikesDto> getByBoardId(long boardId) {

        return likesMapper.getByBoardId(boardId);
    }

    @Override
    public void addLike(LikesDto likesDto) {
        boolean exists = likesMapper.liked(likesDto.getBoardId(), likesDto.getUserId());
        if (exists) {
            throw new BusinessException(ErrorCode.BOARD_ALREADY_EXISTS);
        }
        likesMapper.addLike(likesDto);
    }

    @Override
    public void deleteLike(LikesDto dto) {

        likesMapper.deleteLike(dto);
    }

    @Override
    public int countByBoardId(long boardId) {

        return likesMapper.countByBoardId(boardId);
    }

    @Override
    public boolean liked(long boardId, long userId) {

        return likesMapper.liked(boardId, userId);
    }
}
