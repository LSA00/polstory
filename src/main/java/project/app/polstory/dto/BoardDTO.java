package project.app.polstory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Date;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class BoardDTO {

    private Long boardIdx;
    private Long memIdx;
    private String boardContent;
    private String boardTitle;
    private String boardTags;
    private Date boardDate;
    private Boolean boardShow;
    private int cateNum;

}
