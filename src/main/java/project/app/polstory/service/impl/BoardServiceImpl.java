package project.app.polstory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project.app.polstory.dto.BoardDTO;
import project.app.polstory.dto.PageRequestDTO;
import project.app.polstory.dto.PageResultDTO;
import project.app.polstory.entity.Board;
import project.app.polstory.repository.BoardRepository;
import project.app.polstory.service.BoardService;

import java.util.function.Function;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public PageResultDTO<BoardDTO, Board> boardList(PageRequestDTO pageRequestDTO) {
    // 기초적인 리스트 가져오기.
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("boardId").descending());

        Page<Board> result = boardRepository.findByShowAndDel(true , false , pageable);

        Function<Board , BoardDTO> fn = (this::entityToDto);

        return new PageResultDTO<>(result,fn);
    }
}
