package com.staylog.staylog.domain.admin.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 *  유저 상태 변경
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUpdateStatusResponse {
    private Long userId;
    private String userName;
    private String userStatus;

    private LocalDateTime updatedAt;
}

