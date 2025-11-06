package com.staylog.staylog.global.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 회원가입 이벤트 객체
 * @author 이준혁
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignupEvent {
    private long userId; // 가입된 유저의 PK
    private String nickname; // 유저 닉네임
}
