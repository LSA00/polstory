package project.app.polstory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
