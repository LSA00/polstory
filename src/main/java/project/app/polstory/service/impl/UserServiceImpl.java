package project.app.polstory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.app.polstory.dto.UserDTO;
import project.app.polstory.entity.User;
import project.app.polstory.repository.UserRepository;
import project.app.polstory.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public void UserSave(UserDTO dto){

        User entity = dtoToEntity(dto);

        userRepository.save(entity);

    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUserId(userId);

        if(user.isPresent()) {
            User preUser = user.get();

            User authUser = User.builder()
                    .userPassword(preUser.getPassword())
                    .userEmail(preUser.getUserEmail())
                    .userNick(preUser.getUserNick())
                    .userName(preUser.getUsername())
                    .userIdx(preUser.getUserIdx())
                    .userId(preUser.getUserId())
                    .userType(preUser.getUserType())
                    .build();

            return authUser;
        }

        return null;
    }
}
