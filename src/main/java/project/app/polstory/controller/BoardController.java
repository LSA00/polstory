package project.app.polstory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.app.polstory.dto.BoardDTO;
import project.app.polstory.dto.PageRequestDTO;
import project.app.polstory.service.BoardService;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private final BoardService boardService;

    @GetMapping("/")
    public String index(){
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void list(@ModelAttribute PageRequestDTO pageRequestDTO, Model model){

        model.addAttribute("board" , boardService.getList(pageRequestDTO));

    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO dto){

        boardService.BoardSave(dto);

        return "redirect:/board/list";
    }

}
