package project.app.polstory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import project.app.polstory.security.Roles;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class UserDTO {

    private Long userIdx;
    private String userId;
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userNick;
    private Roles userType;
    private LocalDateTime regDate, modDate;

}
