package project.app.polstory.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import project.app.polstory.security.Role;

import javax.persistence.*;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "USER_IDX_GENERATOR" , sequenceName = "USER_SEQ", allocationSize = 1) // 시퀀스 생성
@Table(name = "users") // 테이블 네임 선언
@Entity // 엔티티 선언
public class User extends BaseEntity{

    @Id //PRIMARY_KEY
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "USER_IDX_GENERATOR"
    ) // 위에서 정의한 SEQ 를 사용하겠다.
    @Column(name = "USER_ID") // 컬럼의 이름
    private Long id; // 회원 번호
    //@ColumnDefault("'ROLE_GUEST'")
    @Enumerated(EnumType.STRING)
    private Role role; // 권한부여
    @Column(length = 20 , unique = true) //unique = true 속성으로 값이 중복되지 못하게함
    @NotNull
    private String username; //아이디
    @Column(length = 100)
    @NotNull
    private String password; //비밀번호
    @NotNull
    private String email; //이메일
    private String nickname; //등록 할 수 있는 닉네임
    @ToString.Exclude
    @OneToMany(mappedBy = "user") //mappedBy = 연관관계의 주인이 아니다 = 나는 FK가 아니니까 DB에 컬럼 만들지 마.
    private List<Board> board;
    @ToString.Exclude
    @OneToMany(mappedBy = "user") //mappedBy = 연관관계의 주인이 아니다 = 나는 FK가 아니니까 DB에 컬럼 만들지 마. user = 필드의 이름
    private List<Category> category;

    @Builder
    public User(
            Role role, String username , String password ,
            String email , String nickname , Long id
    ){
        this.id = id;
        this.email = email;
        this.role = role;
        this.password = password;
        this.nickname = nickname;
        this.username = username;
    }

}
