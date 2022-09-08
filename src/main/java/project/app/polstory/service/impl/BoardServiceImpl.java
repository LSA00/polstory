package project.app.polstory.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project.app.polstory.dto.BoardDTO;
import project.app.polstory.dto.PageRequestDTO;
import project.app.polstory.dto.PageResultDTO;
import project.app.polstory.entity.Board;
import project.app.polstory.entity.QBoard;
import project.app.polstory.repository.BoardRepository;
import project.app.polstory.service.BoardService;

import java.util.Optional;
import java.util.function.Function;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    public void BoardSave(BoardDTO dto){

        Board entity = dtoToEntity(dto);

        boardRepository.save(entity);
    }

    @Override
    public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("board_Idx").descending());

        BooleanBuilder booleanBuilder = getSearch(requestDTO);

        Page<Board> result = boardRepository.findAll(booleanBuilder,pageable);

        Function<Board,BoardDTO> fn = (this::entityToDto);

        return new PageResultDTO<>(result,fn);
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO){

        String type = requestDTO.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        QBoard qBoard = QBoard.board;

        String keyword = requestDTO.getKeyword();

        BooleanExpression expression = qBoard.boardIdx.gt(0L);

        booleanBuilder.and(expression);

        if(type == null || type.trim().length() == 0){

            return booleanBuilder;

        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(type.contains("t")){
            conditionBuilder.or(qBoard.boardTitle.contains(keyword));
        }
        if(type.contains("c")){
            conditionBuilder.or(qBoard.boardContent.contains(keyword));
        }
        if(type.contains("w")){
            conditionBuilder.or(qBoard.user.userId.contains(keyword));
        }
        if(type.contains("g")){
            conditionBuilder.or(qBoard.boardTags.contains(keyword));
        }

        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;

    }

    @Override
    public BoardDTO getDetail(Long boardIdx) {

        Optional<Board> result = boardRepository.findById(boardIdx);

        return result.map(this::entityToDto).orElse(null);
    }

}
