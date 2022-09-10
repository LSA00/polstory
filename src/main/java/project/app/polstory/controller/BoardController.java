package project.app.polstory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import project.app.polstory.service.BoardService;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private final BoardService boardService;


}
