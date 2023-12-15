/**
 * 
 */
package kr.letech.study.springBoot.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.letech.study.springBoot.user.dto.UsersDTO;
import kr.letech.study.springBoot.user.entity.Users;
import kr.letech.study.springBoot.user.repository.UserRepository;
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
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public List<Users> getUserList() {
		return userRepository.findAll();
	}
	
	@Override
	public Users getUser(String userId) {
		Users user = userRepository.findByUserId(userId);
		return user;
	}

	@Override
	public Users insertUser(UsersDTO usersDTO) {
		Users user = new Users();
		user.setUserId(usersDTO.getUserId());
		user.setUserNm(usersDTO.getUserNm());
		String encodedPassword = this.passwordEncoder.encode(usersDTO.getUserPw());
		user.setUserPw(encodedPassword);
		return userRepository.save(user);
	}
	
	@Override
	public Users updateUser(String userId, String userPw) {
		Users user = userRepository.findByUserId(userId);
		String encodedPassword = this.passwordEncoder.encode(userPw);
		user.setUserPw(encodedPassword);
		return userRepository.save(user);
	}
	
	//validation
	
	//세션 저장시 상수로 빼서 저장하면 편리함
	
	//상세조회도 delYN sql query 에 추가
	
	//e.printTrace ... 쓰면 안 됨 
	
	//생길 수 있는 오류 생각해야 함
	
	// try/catch -> finally 필수 

}
