package project.app.polstory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import project.app.polstory.auth.PrincipalDetails;
import project.app.polstory.dto.BoardDTO;
import project.app.polstory.dto.PageRequestDTO;
import project.app.polstory.dto.PageResultDTO;
import project.app.polstory.dto.UserDTO;
import project.app.polstory.entity.Board;
import project.app.polstory.service.BoardService;
import project.app.polstory.service.UserService;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private BoardService boardService;

    @PostMapping(value = "/join")
    public String join(@ModelAttribute UserDTO userDTO){
        userService.saveUser(userDTO);
        return "회원가입 성공";
    }
    @GetMapping(value = "board")
    public PageResultDTO<BoardDTO, Board> boardList(){
        return boardService.boardList(new PageRequestDTO());
    }
    @GetMapping(value = "/test/login")
    public @ResponseBody String testLogin(
            Authentication authentication,
            @AuthenticationPrincipal PrincipalDetails userDetails){
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        System.out.println(principalDetails.getUser());
        System.out.println(userDetails.getUser());
        return "세션 저장 확인하기";
    }

}
