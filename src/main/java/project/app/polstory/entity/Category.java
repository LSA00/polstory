package project.app.polstory.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID")
    private long categoryId;

    private String title; //카테고리의 이름을 설정

    @ManyToOne(fetch = FetchType.LAZY) //Many = board , One = user , 기본 Fetch 전략 EAGER 타입
    @JoinColumn(name = "USER_ID")
    private User user; //DB는 오브젝트를 저장할 수 없다. FK,자바는 오브젝트를 저장할 수 있다. 여기서 충돌이 일어남.

    //mappedBy = 연관관계의 주인이 아니다 = 나는 FK가 아니니까 DB에 컬럼 만들지 마.
    //기본 Fetch 전략이 LAZE 타입
    @OneToMany(mappedBy = "category")
    private List<Board> board;


}
