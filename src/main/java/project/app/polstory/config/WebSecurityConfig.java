package project.app.polstory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import project.app.polstory.security.Roles;

@Configuration
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터 체인에 등록됨
public class WebSecurityConfig {

    //해당 메서드의 리턴되는 오브젝트를 IoC로 등록해준다.
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean //부여된 권한에 따라서 접근 가능한 URL 설정.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        //csrf 설정 끄기
        http.csrf().disable();

        //권한에 따른 접근
        http.authorizeHttpRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/guest/**").authenticated()
                .antMatchers("/user/**").hasAnyRole(Roles.USER.getAuthority(),Roles.ADMIN.getAuthority())
                .antMatchers("/admin/**").hasRole(Roles.ADMIN.getAuthority())
                .antMatchers("/**").permitAll()
                .and()
        //로그인 페이지 설정
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login")
                .usernameParameter("userId")
                .passwordParameter("userPassword")
                .defaultSuccessUrl("/");

        return http.build();
    }

    //이미지나 CSS , js 파일등 권한 없이도 사용해야하는 요소들을 권한 없이 접근 할 수 있게 해준다.
    @Bean
    public WebSecurityCustomizer WebSecurityCustomizer () throws Exception {
        //권한 없이 접근 가능한 파일 설정
        return (web) -> web.ignoring().antMatchers("/static/js/**","/static/css/**","/static/img/**","/static/frontend/**");
    }

}
