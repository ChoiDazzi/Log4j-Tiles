package kr.letech.study.cmmn.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.letech.study.cmmn.security.service.UserLoginServiceImpl;
import kr.letech.study.cmmn.security.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {
	private final UserLoginServiceImpl userLoginService;
	
	@GetMapping("/login")
	public String getLogin() {
		return "login/login.main";
	}

	@GetMapping("/signIn")
	public String getSignIn(Model model) {
		model.addAttribute("auths",userLoginService.getAllAuth());
		return "login/signIn.main";	
	}
	
	@PostMapping("/signIn")
	public String signIn(UserVO userVO, @RequestParam List<String> authId) {
		System.out.println("userVO" + userVO);
		System.out.println("authId = " + authId);
		userLoginService.signIn(userVO, authId);
		return "/login";
	}
	
}
