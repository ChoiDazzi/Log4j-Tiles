package kr.letech.study.cmmn.security.service;

import kr.letech.study.cmmn.security.UserMapper;
import kr.letech.study.cmmn.security.vo.UserDetailsVO;
import kr.letech.study.cmmn.security.vo.UserVO;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userLoginService")
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserDetailsService{
	private final MessageSource messageSource;
	private final UserMapper userMapper;
	
	public List<String> getAllAuth() {
		return userMapper.getAllAuth();
	}
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserDetailsVO userDetailsVO = new UserDetailsVO();

		UserVO userVO = userMapper.getUserInfo(userId);
		if (userVO == null) {
			Locale locale = LocaleContextHolder.getLocale();
			String errMsg = this.messageSource.getMessage("msg.login.notFound", new String[] { userId }, locale);
			throw new UsernameNotFoundException(errMsg);
		} else {
			userDetailsVO.setUsername(userVO.getUserId());
			userDetailsVO.setPassword(userVO.getUserPw());
			userDetailsVO.setAuthorities(userMapper.getUserAuth(userId));
		}

		return userDetailsVO;
	}

//	public static void main(String[] args) {
//		BCryptPasswordEncoder bp = new BCryptPasswordEncoder();
//		System.out.println(bp.encode("123"));
//	}
}
