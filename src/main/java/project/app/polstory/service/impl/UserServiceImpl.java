package project.app.polstory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.app.polstory.dto.UserDTO;
import project.app.polstory.entity.User;
import project.app.polstory.repository.UserRepository;
import project.app.polstory.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void userSave(UserDTO dto) {
        User user = dtoToEntity(dto);
        userRepository.save(user);
    }

    public UserDTO findUser(Long id){
       User user = userRepository.findById(id).orElseThrow(()->{
           return new IllegalArgumentException("아이디가 없습니다." + id);
       });

       return UserDTO.builder()
               .nickname(user.getNickname())
               .id(user.getId())
               .password(user.getPassword())
               .username(user.getUsername())
               .role(user.getRole())
               .email(user.getEmail())
               .build();
    }

    private User dtoToEntity(UserDTO dto){
        return User.builder()
                .id(dto.getId())
                .role(dto.getRole())
                .password(passwordEncoder.encode(dto.getPassword()))
                .email(dto.getEmail())
                .username(dto.getUsername())
                .nickname(dto.getNickname())
                .build();
    }
}
