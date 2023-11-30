package kr.letech.study.cmmn.security.service;

import kr.letech.study.cmmn.security.UserMapper;
import kr.letech.study.cmmn.security.vo.UserDetailsVO;
import kr.letech.study.cmmn.security.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userLoginService")
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserDetailsService{
	private final MessageSource messageSource;
	private final UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserDetailsVO userDetailsVO = new UserDetailsVO();

		UserVO userVO = userMapper.getUserInfo(userId);
		if (userVO == null) {
			return null;
		} else {
			userDetailsVO.setUsername(userVO.getUserId());
			userDetailsVO.setPassword(userVO.getUserPw());
			userDetailsVO.setAuthorities(userMapper.getUserAuth(userId));
		}

		return userDetailsVO;
	}
}
