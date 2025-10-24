package com.staylog.staylog.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;


/** 
 * 유저 정보 반환용 중첩클래스
 * **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long userId;
    private String loginId;
    private String password;
    private String nickname;
    private String name;
    private String email;
    private String phone;
    private String profileImage;
    private Date birthDate;
    private String gender;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String role;
    private String status;
    private Timestamp lastLogin;
    private Timestamp withdrawnAt;
}
