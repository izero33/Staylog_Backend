package com.staylog.staylog.domain.auth.controller;

import com.staylog.staylog.domain.auth.dto.request.LoginRequest;
import com.staylog.staylog.domain.auth.dto.request.SignupRequest;
import com.staylog.staylog.domain.auth.dto.response.LoginResponse;
import com.staylog.staylog.domain.auth.dto.response.TokenResponse;
import com.staylog.staylog.domain.auth.service.AuthService;
import com.staylog.staylog.global.common.response.SuccessResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public ResponseEntity<SuccessResponse<LoginResponse>> login(@RequestBody @Valid LoginRequest loginRequest,
                                               HttpServletRequest request,
                                               HttpServletResponse response){

        log.info("로그인 요청 : {}", loginRequest.getLoginId());

        LoginResponse loginResponse = authService.login(loginRequest, request, response);

        //공통 응답 SuccessResponse로 감싸기
        SuccessResponse<LoginResponse> success = SuccessResponse.of("로그인 성공", loginResponse);
        return ResponseEntity.ok(success);

    }

    @PostMapping("/logout")
    public ResponseEntity<SuccessResponse<Void>> logout(
            HttpServletRequest request,
            HttpServletResponse response) {

        authService.logout(request, response);
        //공통 응답 SuccessResponse로 감싸기
        SuccessResponse<Void> success = SuccessResponse.of("로그아웃 성공");
        return ResponseEntity.ok(success);
    }

    @PostMapping("/refresh")
    public ResponseEntity<SuccessResponse<TokenResponse>> refresh(
            HttpServletRequest request,
            HttpServletResponse response) {

        TokenResponse tokenResponse = authService.refreshAccessToken(request,response);
        //공통 응답 SuccessResponse로 감싸기
        SuccessResponse success = SuccessResponse.of("토큰 갱신 성공", tokenResponse);
        return ResponseEntity.ok(success);
    }


    /**
     * 회원가입 메서드
     * @author 이준혁
     * @return 생성된 유저의 PK
     */    @PostMapping("/user")
    public ResponseEntity<SuccessResponse<Long>> UserSignup(SignupRequest signupRequest) {

        long userId = authService.signupUser(signupRequest);

        //공통 응답 SuccessResponse로 감싸기
        SuccessResponse<Long> success = SuccessResponse.of("회원가입 성공",userId);
        return ResponseEntity.ok(success);
    }
}

