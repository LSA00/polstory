package project.app.polstory.service;

import org.springframework.stereotype.Service;
import project.app.polstory.dto.BoardDTO;
import project.app.polstory.dto.PageRequestDTO;
import project.app.polstory.dto.PageResultDTO;
import project.app.polstory.entity.Board;
import project.app.polstory.entity.User;

@Service
public interface BoardService {

    PageResultDTO<BoardDTO, Board> boardList(PageRequestDTO pageRequestDTO);

    default Board dtoToEntity(BoardDTO dto, User user){
        return Board.builder()
                .user(user)
                .category(dto.getCategory())
                .boardId(dto.getBoardId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .tags(dto.getTags())
                .show(dto.isShow())
                .del(dto.isDel())
                .count(dto.getCount())
                .build();
    }

    default BoardDTO entityToDto(Board entity){
        return BoardDTO.builder()
                .user(entity.getUser())
                .category(entity.getCategory())
                .boardId(entity.getBoardId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .tags(entity.getTags())
                .show(entity.isShow())
                .del(entity.isDel())
                .count(entity.getCount())
                .build();
    }

}
