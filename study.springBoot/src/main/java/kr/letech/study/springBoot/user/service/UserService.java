/**
 * 
 */
package kr.letech.study.springBoot.user.service;

import java.util.List;

import org.apache.catalina.User;

import kr.letech.study.springBoot.user.dto.UsersDTO;
import kr.letech.study.springBoot.user.entity.Users;

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
public interface UserService {
	/**
	 * 사용자 목록 조회
	 * @return
	 */
	List<Users> getUserList();
	
	/**
	 * 사용자 조회
	 * @param userId
	 * @return
	 */
	Users getUser(String userId);
	
	/**
	 * 사용자 등록
	 * @param usersDTO
	 * @return
	 */
	Users insertUser(UsersDTO usersDTO);

	/**
	 * 사용자 비밀번호 변경
	 * @param userId
	 * @param userPw
	 * @return
	 */
	Users updateUser(String userId, String userPw);
}
