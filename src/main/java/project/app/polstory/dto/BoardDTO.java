package project.app.polstory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import project.app.polstory.entity.Category;
import project.app.polstory.entity.User;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class BoardDTO {

    Long boardId;
    String title;
    String content;
    int count;
    String tags;
    boolean del;
    boolean show;
    User user;
    Category category;

}
