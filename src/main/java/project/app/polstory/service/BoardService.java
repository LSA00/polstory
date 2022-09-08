package project.app.polstory.service;

import project.app.polstory.dto.BoardDTO;
import project.app.polstory.dto.PageRequestDTO;
import project.app.polstory.dto.PageResultDTO;
import project.app.polstory.entity.Board;

public interface BoardService {

    void BoardSave(BoardDTO dto);

    PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO);

    BoardDTO getDetail(Long boardIdx);

    default Board dtoToEntity(BoardDTO dto){
        Board entity = Board.builder()
                .boardContent(dto.getBoardContent())
                .boardIdx(dto.getBoardIdx())
                .boardShow(dto.getBoardShow())
                .boardTags(dto.getBoardTags())
                .boardTitle(dto.getBoardTitle())
                .cateNum(dto.getCateNum())
                .user(dto.getUser())
                .build();

        return entity;
    }

    default  BoardDTO entityToDto(Board entity){
        BoardDTO DTO = BoardDTO.builder()
                .boardContent(entity.getBoardContent())
                .boardIdx(entity.getBoardIdx())
                .boardShow(entity.getBoardShow())
                .boardTags(entity.getBoardTags())
                .boardTitle(entity.getBoardTitle())
                .cateNum(entity.getCateNum())
                .user(entity.getUser())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

        return DTO;
    }
}
