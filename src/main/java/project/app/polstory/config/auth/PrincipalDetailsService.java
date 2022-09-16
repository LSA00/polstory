package project.app.polstory.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.app.polstory.entity.User;
import project.app.polstory.repository.UserRepository;

//시큐리티 설정에서 loginProcessingURL
//  /login 요청이 오면 자동으로 UserDetailService 타입으로 IoC 되어있는 loadByUserName 함수가 실행
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //스프링이 로그인 요청을 가로챌 때 , username , password 변수 2개를 가로챈다.
    // password 부분은 알아서 처리하기 때문에 username이 DB에 있는지 확인해줘야함.
    //시큐리티 session 내부 Authentication(내부 UserDetails))
    //함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어진다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username).orElseThrow(()-> new RuntimeException("유저 정보가 없습니다. :" + username));
        return new PrincipalDetails(principal); //시큐리티 세션에 유저 정보가 저장됨.
    }
}
