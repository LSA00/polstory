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

    public void UserSave(UserDTO dto){

        User entity = dtoToEntity(dto);

        userRepository.save(entity);

    }

    private User dtoToEntity(UserDTO dto){

        return User.builder()
                .userNick(dto.getUserNick())
                .userId(dto.getUserId())
                .userPassword(passwordEncoder.encode(dto.getUserPassword()))
                .userEmail(dto.getUserEmail())
                .userName(dto.getUserName())
                .userIdx(dto.getUserIdx())
                .userType(dto.getUserType())
                .build();
    }

    private UserDTO entityToDTO(User entity){

        return UserDTO.builder()
                .userId(entity.getUserId())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .userEmail(entity.getUserEmail())
                .userIdx(entity.getUserIdx())
                .userName(entity.getUsername())
                .userNick(entity.getUserNick())
                .userPassword(entity.getUserPassword())
                .userType(entity.getUserType())
                .build();
    }

}
