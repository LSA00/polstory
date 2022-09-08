package project.app.polstory.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Roles implements GrantedAuthority {

    ADMIN("ROLE_ADMIN" , "관리자"),
    USER("ROLE_USER" , "유저"),
    GUEST("ROLE_GUEST" , "게스트");

    private final String Authority;
    private final String description;

    @Override
    public String getAuthority() {
        return Authority;
    }

    public String getDescription() {
        return description;
    }
}
