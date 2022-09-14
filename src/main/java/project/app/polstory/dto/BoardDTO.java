package project.app.polstory.dto;

import lombok.*;
import project.app.polstory.entity.Category;
import project.app.polstory.entity.User;

@Getter
@Setter
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
