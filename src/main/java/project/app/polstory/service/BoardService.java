package project.app.polstory.service;

import org.springframework.stereotype.Service;
import project.app.polstory.dto.BoardDTO;
import project.app.polstory.entity.Board;

@Service
public interface BoardService {

    default Board dtoToEntity(BoardDTO dto){
        Board entity = Board.builder()
                .boardContent(dto.getBoardContent())
                .boardDate(dto.getBoardDate())
                .boardIdx(dto.getBoardIdx())
                .boardShow(dto.getBoardShow())
                .boardTags(dto.getBoardTags())
                .boardTitle(dto.getBoardTitle())
                .cateNum(dto.getCateNum())
                .memIdx(dto.getMemIdx())
                .build();

        return entity;
    }

    default  BoardDTO entityToDto(Board entity){
        BoardDTO DTO = BoardDTO.builder()
                .boardContent(entity.getBoardContent())
                .boardDate(entity.getBoardDate())
                .boardIdx(entity.getBoardIdx())
                .boardShow(entity.getBoardShow())
                .boardTags(entity.getBoardTags())
                .boardTitle(entity.getBoardTitle())
                .cateNum(entity.getCateNum())
                .memIdx(entity.getMemIdx())
                .build();

        return DTO;
    }
}
