package project.app.polstory.dto;

import lombok.*;
import project.app.polstory.entity.Board;
import project.app.polstory.entity.Category;
import project.app.polstory.security.Role;

import java.util.List;

@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class UserDTO {
    private Long id;
    private Role role;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String provider;
    private String providerId;
    @ToString.Exclude
    private List<Board> board;
    @ToString.Exclude
    private List<Category> category;
}
