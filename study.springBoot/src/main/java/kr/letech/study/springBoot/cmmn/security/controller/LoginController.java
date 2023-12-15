package kr.letech.study.springBoot.cmmn.security.controller;

import javax.naming.AuthenticationException;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.letech.study.springBoot.cmmn.security.service.CustomAuthenticationProvider;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final CustomAuthenticationProvider authenticationProvider;

    @PostMapping("/api/v1/users/login")
    public ResponseEntity<String> login(String userId, String userPw) throws AuthenticationException {
        // 인증을 위한 토큰 생성
		Authentication authentication = new UsernamePasswordAuthenticationToken(userId, userPw);
		
		// 인증을 수행하고 결과를 받음
		Authentication result = authenticationProvider.authenticate(authentication);
		
		// SecurityContext에 인증 정보 설정
		SecurityContextHolder.getContext().setAuthentication(result);
		
		return ResponseEntity.ok("Login Success");
    }
}

