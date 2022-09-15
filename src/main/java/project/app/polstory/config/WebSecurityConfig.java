package project.app.polstory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import project.app.polstory.config.auth.PrincipalDetailsService;
import project.app.polstory.config.oauth.PrincipalOauth2UserService;
import project.app.polstory.security.Role;

@Configuration //빈 등록 (IoC 관리)
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터 체인에 등록됨
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크.
public class WebSecurityConfig {

    //해당 메서드의 리턴되는 오브젝트를 IoC로 등록해준다.

    @Autowired
    private PrincipalDetailsService principalDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    @Bean //부여된 권한에 따라서 접근 가능한 URL 설정.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        //csrf 설정 끄기
        http.csrf().disable();

        //권한에 따른 접근
        http.authorizeHttpRequests()
                .antMatchers("/guest/**").authenticated() //인증만 되면 들어갈 수 있는 주소
                .antMatchers("/user/**").hasAnyRole(Role.USER.getAuthority(),Role.ADMIN.getAuthority()) //user , admin 계정인 경우 들어갈 수 있는 주소
                .antMatchers("/admin/**").hasRole(Role.ADMIN.getAuthority()) //admin만 들어갈 수 있는 주소
                .antMatchers("/**").permitAll(); // 나머지 주소는 일단 모두 들어갈 수 있게함
        //구글 로그인
        //1.코드 받기(인증) , 2.엑세스 토큰(권한 - 사용자 정보에 접근할 권한),
        //3.사용자 프로필 정보를 가져온다. 4-1.그 정보를 토대로 회원가입을 진행
        //4-2. 정보가 모자란 경우 추가 정보를 받아서 회원가입.
        http
                .oauth2Login()
                .loginPage("/loginForm")//구글 로그인이 완료된 뒤의 후 처리가 필요함 tip. 코드X,(엑세스 토큰 + 사용자 프로필 정보O)
                .userInfoEndpoint()
                .userService(principalOauth2UserService);
        //form login
        http
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .failureForwardUrl("/");

        return http.build();
    }

    //이미지나 CSS , js 파일등 권한 없이도 사용해야하는 요소들을 권한 없이 접근 할 수 있게 해준다.
    @Bean
    public WebSecurityCustomizer WebSecurityCustomizer () {
        //권한 없이 접근 가능한 파일 설정
        return (web) -> web.ignoring().antMatchers("/static/js/**","/static/css/**","/static/img/**");
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(principalDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }

}
