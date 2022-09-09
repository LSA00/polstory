package project.app.polstory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import project.app.polstory.entity.Board;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class FileDTO {
    private Long fileIdx;
    private Long boardIdx;
    private String orgName;
    private String stdName;
    private Boolean del;
    private String imageSize;
    private LocalDateTime regDate, modDate;

}
