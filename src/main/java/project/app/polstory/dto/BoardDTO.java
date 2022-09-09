package project.app.polstory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import project.app.polstory.entity.Category;
import project.app.polstory.entity.User;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class BoardDTO {

    private Long boardIdx;
    private User user;
    private String boardContent;
    private String boardTitle;
    private String boardTags;
    private Boolean boardShow;
    private Category category;
    private LocalDateTime regDate, modDate;

}
