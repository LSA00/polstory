package project.app.polstory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //기본 Url
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");

        //로그인 페이지
        registry.addViewController("/loginForm").setViewName("loginForm");

        //회원가입 페이지
        registry.addViewController("/joinForm").setViewName("joinForm");
    }

    @Bean
    public SpringSecurityDialect securityDialect(){
        return new SpringSecurityDialect();
    }

}
