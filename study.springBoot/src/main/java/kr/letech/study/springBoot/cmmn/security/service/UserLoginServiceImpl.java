package kr.letech.study.springBoot.cmmn.security.service;

import kr.letech.study.springBoot.cmmn.security.vo.UserDetailsVO;
import kr.letech.study.springBoot.user.entity.Users;
import kr.letech.study.springBoot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.userRepository.findByUserId(username);
        // 사용자 없는 경우
        if (user == null) {
            throw new UsernameNotFoundException(username + "사용자가 존재하지 않습니다.");
        }
        UserDetailsVO userDetailsVO = new UserDetailsVO(user);
        return userDetailsVO;
    }
}
