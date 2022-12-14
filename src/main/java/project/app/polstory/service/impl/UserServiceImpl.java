package project.app.polstory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.app.polstory.dto.UserDTO;
import project.app.polstory.entity.User;
import project.app.polstory.repository.UserRepository;
import project.app.polstory.security.Role;
import project.app.polstory.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void saveUser(UserDTO dto) {
        dto.setRole(Role.GUEST); //초기 Role 세팅
        dto.setPassword(passwordEncoder.encode(dto.getPassword())); //비밀번호 해쉬화
        User user = dtoToEntity(dto);
        userRepository.save(user);
    }

    public UserDTO findUser(Long id){
       User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다." + id));

       return entityToDto(user);
    }

    private User dtoToEntity(UserDTO dto){
        return User.builder()
                .id(dto.getId())
                .role(dto.getRole())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .nickname(dto.getNickname())
                .provider(dto.getProvider())
                .providerId(dto.getProviderId())
                .build();
    }

    private UserDTO entityToDto(User entity){

        return UserDTO.builder()
                .nickname(entity.getNickname())
                .id(entity.getId())
                .password(entity.getPassword())
                .username(entity.getUsername())
                .role(entity.getRole())
                .email(entity.getEmail())
                .provider(entity.getProvider())
                .providerId(entity.getProviderId())
                .build();
    }
}
