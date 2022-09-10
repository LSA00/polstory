package project.app.polstory.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Role implements GrantedAuthority {

    ADMIN("ROLE_ADMIN" , "관리자"),
    USER("ROLE_USER" , "유저"),
    GUEST("ROLE_GUEST" , "게스트"),
    DROP("ROLE_DROP" , "탈퇴"),
    DENY("ROLE_DENY" , "정지");

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
