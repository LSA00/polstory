package project.app.polstory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import project.app.polstory.repository.BoardRepository;
import project.app.polstory.service.BoardService;

public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

}
