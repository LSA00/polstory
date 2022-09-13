package project.app.polstory.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.app.polstory.entity.User;

import java.util.ArrayList;
import java.util.Collection;

//시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
//로그인 진행이 완료가 되면 시큐리티 session을 만든다.(Security ContextHolder)
//시큐리티 세션에 들어갈 수 있는 오브젝트는 정해져있음. (Authentication 타입의 객체)
//user 오브젝트 타입 => userDetails 타입 객체
public class PrincipalDetails implements UserDetails {

    private final User user; //콤포지션

    public PrincipalDetails(User user){
        this.user = user;
    }

    @Override //계정의 권한을 리턴
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add((GrantedAuthority) () -> user.getRole().getAuthority());

        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override //계정이 만료되었는지 리턴한다.
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override //계정이 잠겨있는지를 리턴
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override //비밀번호가 만료되었는지 리턴
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override //계정이 활성화 되어있는지 리턴
    public boolean isEnabled() {
        return true;
    }
}
