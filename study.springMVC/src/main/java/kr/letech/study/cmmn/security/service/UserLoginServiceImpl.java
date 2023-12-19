package kr.letech.study.cmmn.security.service;

import kr.letech.study.cmmn.security.UserMapper;
import kr.letech.study.cmmn.security.vo.RoleVO;
import kr.letech.study.cmmn.security.vo.UserAuthVO;
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
	
	public List<RoleVO> getAllAuth() {
		return userMapper.getAllAuth();
	}

	public void signIn(UserVO userVO, List<String> authId) {
		UserAuthVO userAuthVO = new UserAuthVO();
		BCryptPasswordEncoder bp = new BCryptPasswordEncoder();
		userVO.setUserPw(bp.encode(userVO.getUserPw()));
		userMapper.signInUser(userVO);

		userAuthVO.setUserId(userVO.getUserId());
		for (String auth : authId) {
			userAuthVO.setRoleId(auth);
			userMapper.signInAuth(userAuthVO);
		}
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

}
