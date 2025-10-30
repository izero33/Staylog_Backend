package com.staylog.staylog.domain.admin.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 유저 권한 변경을 위한 객체
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminUpdateRoleRequest {
    private String role;
}
