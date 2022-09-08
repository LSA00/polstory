package project.app.polstory.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Roles {
    ADMIN("ROLE_ADMIN" , "어드민"),
    USER("ROLE_USER" , "사용자"),
    GUEST("ROLE_GUEST" ,"방문자");

    private String key;
    private String title;
}
