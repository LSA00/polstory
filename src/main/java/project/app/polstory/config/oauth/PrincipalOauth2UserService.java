package project.app.polstory.config.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import project.app.polstory.config.auth.PrincipalDetails;
import project.app.polstory.config.oauth.provider.FacebookUserInfo;
import project.app.polstory.config.oauth.provider.GoogleUserInfo;
import project.app.polstory.config.oauth.provider.NaverUserInfo;
import project.app.polstory.config.oauth.provider.OAuth2UserInfo;
import project.app.polstory.entity.User;
import project.app.polstory.repository.UserRepository;
import project.app.polstory.security.Role;

import java.util.Map;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    //구글로 부터 받은 userRequest 데이터에 대한 후처리 되는 함수
    //함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어진다.
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{

        System.out.println("getClientRegistration : " + userRequest.getClientRegistration());
        System.out.println("getAccessToken : " + userRequest.getAccessToken());

        OAuth2User oAuth2User = super.loadUser(userRequest);
        //구글 로그인 버튼 클릭 -> 구글 로그인창 ->로그인을 완료 ->code 를 리턴(Oauth-client 라이브러리)->AccessToken 요청
        //userRequest 정보 -> loadUser 함수 호출 ->구글로부터 회원 프로필을 받아준다.
        System.out.println("getAttributes : " + oAuth2User.getAttributes());

        OAuth2UserInfo oAuth2UserInfo = null;

        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("facebook")){
            oAuth2UserInfo = new FacebookUserInfo(oAuth2User.getAttributes());
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
        }

        String provider = oAuth2UserInfo.getProvider();
        String providerId = oAuth2UserInfo.getProviderId();
        String username = provider+"_"+providerId;
        String password = passwordEncoder.encode("임시 비밀번호");
        String email = oAuth2UserInfo.getEmail();
        String nickname = oAuth2UserInfo.getName();
        Role role = Role.USER;

        User user = userRepository.findByUsername(username).orElse(null);

        if(user == null){
            user = User.builder()
                    .role(role)
                    .providerId(providerId)
                    .email(email)
                    .nickname(nickname)
                    .username(username)
                    .provider(provider)
                    .password(password)
                    .build();
            userRepository.save(user);
        }

        return new PrincipalDetails(user , oAuth2User.getAttributes());
    }
}
