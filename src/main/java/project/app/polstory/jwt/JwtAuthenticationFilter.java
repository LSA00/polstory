package project.app.polstory.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//스프링 시큐리티에서 UsernamePasswordAuthenticationFilter가 있음
// /login 요청시 username , password 를 전송하면 (POST 방식)
// UsernamePasswordAuthenticationFilter 가 동작하게됨.
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter : 로그인 시도중");

        // 1. username , password를 받아서 정상인지 로그인 시도를 해본다.
        // 2. authenticationManager 로 로그인 시도를 하면
        // PrincipalDetailsService 가 호출 , loadUserByUsername() 함수 실행됨.
        // 3. PrincipalDetails를 세션에 담고 -> 세션에 담지 않으면 권한관리가 실행이 되지 않음
        // 4. JWT토큰을 만들어서 응답해주면 됨.
        return super.attemptAuthentication(request, response);
    }
}
