package project.app.polstory.service;

import project.app.polstory.dto.UserDTO;

public interface UserService {
    void saveUser(UserDTO dto);
    UserDTO findUser(Long id);
}
