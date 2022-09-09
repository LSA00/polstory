package project.app.polstory.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.app.polstory.security.Roles;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "USER_IDX_GENERATOR" , sequenceName = "USER_SEQ", allocationSize = 1)
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "USER_IDX_GENERATOR"
    )
    @Column(unique = true)
    private Long userIdx;
    @Column(name = "USER_ID",unique = true)
    @NotNull
    private String userId;
    @Column(unique = true)
    @NotNull
    private String userEmail;
    @NotNull
    private String userPassword;
    @NotNull
    private String userName;
    private String userNick;

    @Enumerated(EnumType.STRING)
    private Roles userType;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    List<Board> boardList = new ArrayList<>();


    @Builder
    public User(
            Long userIdx, String userId, String userEmail, String userPassword,
            String userName, String userNick ,Roles userType) {
        this.userEmail = userEmail;
        this.userId = userId;
        this.userIdx = userIdx;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNick = userNick;
        this.userType = userType;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        for( String userType : userType.getAuthority().split(",")){
            authorities.add(new SimpleGrantedAuthority(userType));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.getUserPassword();
    }

    @Override
    public String getUsername() {
        return this.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
