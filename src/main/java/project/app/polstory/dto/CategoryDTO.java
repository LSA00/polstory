package project.app.polstory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import project.app.polstory.entity.User;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class CategoryDTO {
    private Long cateNum;
    private User user;
    private String cateName;
    private LocalDateTime regDate, modDate;
}
