package project.app.polstory.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import project.app.polstory.security.Roles;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "USERIDX_SEQ_GENERATOR" , sequenceName = "USERIDX_SEQ")
@Table(name = "users")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userIdx;
    private String userId;
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userNick;

    private Roles userType;

    @OneToMany(mappedBy = "user")
    List<Board> boardList = new ArrayList<Board>();


    @Builder
    public User(
            Long userIdx, String userId, String userEmail, String userPassword,
            String userName, String userNick) {
        this.userEmail = userEmail;
        this.userId = userId;
        this.userIdx = userIdx;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNick = userNick;

    }

}
