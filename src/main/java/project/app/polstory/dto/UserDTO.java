package project.app.polstory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import project.app.polstory.entity.Board;
import project.app.polstory.entity.Category;
import project.app.polstory.security.Role;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class UserDTO {
    private Long id;
    private Role role;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private List<Board> board;
    private List<Category> category;
}
