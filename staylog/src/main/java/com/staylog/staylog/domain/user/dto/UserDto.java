package com.staylog.staylog.domain.user.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDto {
    private Long userId;
    private String login_id;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String profileImage;
    private String birth_date;
    private String gender;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String role;
    private String status;
    private LocalDateTime last_login;
    private LocalDateTime withdrawn_at;


}
