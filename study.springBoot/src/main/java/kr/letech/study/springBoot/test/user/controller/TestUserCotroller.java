package kr.letech.study.springBoot.test.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.letech.study.springBoot.test.user.dto.TestUserDTO;
import kr.letech.study.springBoot.test.user.entity.TestUser;
import kr.letech.study.springBoot.test.user.service.TestUserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestUserCotroller {
	
	private final TestUserService userService;
	 
	@GetMapping("/api/v1/test/users")
	public ResponseEntity<List<TestUser>> list() {
		List<TestUser> result = this.userService.selectUserList();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/api/v1/test/users/{ID}")
	public ResponseEntity<TestUser> get(@PathVariable("ID") Long ID) {
		TestUser result = this.userService.selectUser(ID);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/api/v1/test/users")
	public ResponseEntity<TestUser> insert(TestUserDTO testUserDTO) {
		TestUser result = this.userService.insertUser(testUserDTO);
		return ResponseEntity.ok(result);
	}
}
