package project.app.polstory.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.app.polstory.entity.User;

import java.util.Collection;

//시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
//로그인 진행이 완료가 되면 시큐리티 session을 만든다.(Seciroty ContextHolder)
//시큐리티 세션에 들어갈 수 있는 오브젝트는 정해져있음. (Authentication 타입의 객체)
//user 오브젝트 타입 => userDetails 타입 객체

public class PrincipalDetails implements UserDetails {

    private User user; //콤포지션

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
