package project.app.polstory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.app.polstory.dto.UserDTO;
import project.app.polstory.security.Roles;
import project.app.polstory.service.UserService;

@Controller
public class TestController {

    @Autowired
    private UserService userService;


    @GetMapping("/test")
    @ResponseBody
    public String test(){

        UserDTO dto = UserDTO.builder()
                .userType(Roles.ADMIN)
                .userEmail("test Email")
                .userName("admin test")
                .userNick("admin")
                .userPassword("admin")
                .userId("admin")
                .build();

        userService.UserSave(dto);

        return "OK";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String adminOnly(){
        return "Secret Page";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user(){
        return "user Page";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "/joinForm";
    }

    @PostMapping("/join")
    public String join(UserDTO dto){

        userService.UserSave(dto);

        return "redirect:/";
    }


}
