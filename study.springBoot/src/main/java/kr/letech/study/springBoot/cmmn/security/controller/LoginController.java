package kr.letech.study.springBoot.cmmn.security.controller;

import kr.letech.study.springBoot.cmmn.security.service.UserLoginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserLoginServiceImpl userLoginService;

    @PostMapping("/api/v1/users/login")
    public ResponseEntity<String> login(String userId, String userPw) {
//        System.out.println("userId = " + userId);
//        System.out.println("userPw = " + userPw);
//        userLoginService.loadUserByUsername(userId);
        return ResponseEntity.ok("success");
    }
}
