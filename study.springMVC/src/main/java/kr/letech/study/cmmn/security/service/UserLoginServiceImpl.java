package kr.letech.study.cmmn.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import kr.letech.study.cmmn.security.vo.UserDetailsVO;
import lombok.RequiredArgsConstructor;

@Service("userLoginService")
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserDetailsService{
	private final MessageSource messageSource;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		UserDetailsVO detailsVO = null;
		//DB로 사용자 정보 가져오는 로직  
		detailsVO = new UserDetailsVO();
		if ("admin".equals(username)) {			
			detailsVO.setPassword("$2a$10$FT5mIozPzVC1hh/oy/0r5.hSk20h0WlXs1UVf76m/4ttB8f4PW1FC"); //123
			List<GrantedAuthority> authList = new ArrayList<>(); 
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			detailsVO.setAuthorities(authList);
		} else if ("test".equals(username)) {
			detailsVO.setPassword("$2a$10$mD.zwegD7KKDKEBnG1F.W.3tt.0Z2deO926ed/D1yQenURgu5l5Oy"); // abc
			List<GrantedAuthority> authList = new ArrayList<>(); 
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));
			detailsVO.setAuthorities(authList);
		} else {
			Locale locale = LocaleContextHolder.getLocale();
			String errMsg = messageSource.getMessage("msg.login.notFound", new String[] {username}, locale);
			throw new UsernameNotFoundException(errMsg);
		}
		detailsVO.setUsername(username);
		
		return detailsVO;
	}
}
