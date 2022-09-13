package project.app.polstory.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.app.polstory.dto.ResponseDTO;
import project.app.polstory.dto.UserDTO;
import project.app.polstory.service.UserService;

@RestController
public class UserApiController {

    @Autowired
    UserService userService;

    @PostMapping("/api/user")
    public ResponseDTO<Integer> save(@RequestBody UserDTO user){
        userService.saveUser(user);
        return new ResponseDTO<>(HttpStatus.OK.value(), 1);
    }
}
