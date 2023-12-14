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

	/**
	 * 사용자 목록 조회
	 * @return 사용자 목록
	 */
	@GetMapping("/api/v1/users")
	public ResponseEntity<List<Users>> getUserList() {
		List<Users> userList = userService.getUserList();
		return ResponseEntity.ok(userList);
	}

	/**
	 * 사용자 정보 조회
	 * @param userId 사용자 아이디
	 * @return 특정 사용자 정보
	 */
	@GetMapping("/api/v1/users/{userId}")
	public ResponseEntity<Users> getUser(@PathVariable("userId") String userId) {
		Users user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

	/**
	 * 사용자 회원가입
	 * @param usersDTO
	 * @return
	 */
	@PostMapping("/api/v1/users")
	public ResponseEntity<Users> insertUser(UsersDTO usersDTO) {
		Users user = userService.insertUser(usersDTO);
		return ResponseEntity.ok(user);
	}

	/**
	 * 비밀번호 수정
	 * @param userId
	 * @param userPw
	 * @return
	 */
	@PutMapping("/api/v1/users")
	public ResponseEntity<Users> modifyUser(String userId, String userPw) {
		Users user = userService.updateUser(userId, userPw);
		return ResponseEntity.ok(user);
	}
}
