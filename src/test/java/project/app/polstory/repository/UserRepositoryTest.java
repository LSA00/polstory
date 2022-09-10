package project.app.polstory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.app.polstory.entity.User;
import project.app.polstory.security.Role;

import java.util.stream.IntStream;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertDummies(){
        IntStream.rangeClosed(1,30).forEach(i->{
            User user = User.builder()
                    .nickname("test nickname " + i)
                    .username("test"+ i)
                    .email("test email" + i)
                    .password("password"+i)
                    .role(Role.GUEST)
                    .build();
            userRepository.save(user);
        });
    }

}
