/**
 * 
 */
package kr.letech.study.springBoot.user.service;

import java.util.List;
import java.util.Optional;
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
	@Override
	public List<Users> getUserList() {
		return userRepository.findAll();
	}
	
	@Override
	public Users getUser(Long userId) {
		Optional<Users> userInfo = userRepository.findById(userId);
		if (userInfo.isEmpty()) {
			return null;
		} else {
			return userInfo.get();
		}
	}

	@Override
	public Users insertUser(UsersDTO usersDTO) {
		Users user = new Users();
		user.setUserId(usersDTO.getUserId());
		user.setUserNm(usersDTO.getUserNm());
		// 여기서 사용자 비밀번호를 암호화 해서 넣기... 
		user.setUserPw(usersDTO.getUserPw());
		return userRepository.save(user);
	}
	
	/*
	 * public Notice update(Long noticeId, String content) {
	    Notice notice = noticeRepository.findById(noticeId).get();
	    notice.setContent(content);
	    noticeRepository.save(notice);
}
	 */

	@Override
	public Users updateUser(UsersDTO usersDTO) {
		String userId = usersDTO.getUserId();
		
		return null;
	}

}
