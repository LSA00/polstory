package project.app.polstory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.app.polstory.dto.UserDTO;
import project.app.polstory.entity.User;
import project.app.polstory.repository.UserRepository;
import project.app.polstory.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    UserRepository userRepository;

    public void MemberSave(UserDTO dto){

        User entity = dtoToEntity(dto);

        userRepository.save(entity);

    }

}
