/**
 * 
 */
package kr.letech.study.springBoot.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.letech.study.springBoot.user.dto.UsersDTO;
import kr.letech.study.springBoot.user.entity.Users;
import kr.letech.study.springBoot.user.service.UserService;
import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * 
 * </pre>
 *  
 * << 개정이력 >>
 *   
 *  수정일      수정자		수정내용
 *  ------------------------------------------------
 *  2023-12-14  CSY			최초 생성
 */

@RestController
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/api/v1/users")
	public ResponseEntity<List<Users>> getUserList() {
		List<Users> userList = userService.getUserList();
		return ResponseEntity.ok(userList);
	}
	
	@GetMapping("/api/v1/users/{userId}")
	public ResponseEntity<Users> getUser(@PathVariable("userId") Long userId) {
		Users user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/api/v1/users")
	public ResponseEntity<Users> insertUser(UsersDTO usersDTO) {
		Users user = userService.insertUser(usersDTO);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/api/v1/users")
	public ResponseEntity<Users> modifyUser(UsersDTO usersDTO) {
		Users user = userService.updateUser(usersDTO);
		return ResponseEntity.ok(user);
	}
}
