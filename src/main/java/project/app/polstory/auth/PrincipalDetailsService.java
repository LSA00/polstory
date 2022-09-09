package project.app.polstory.auth;

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

    //시큐리티 Session(내부 Authentication(내부 userDetails))으로 들어감
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("username : " + username);
        User user = userRepository.findByUserId(username);

        if(user != null){
            return new PrincipalDetails(user);
        }

        return null;
    }
}
