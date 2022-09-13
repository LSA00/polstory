package project.app.polstory.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@DynamicInsert // insert 할 때 null 값을 받으면 컬럼의 default 값을 넣어준다.
@DynamicUpdate // update 할 때 null 값을 받으면 컬럼의 default 값을 넣어준다.
@SequenceGenerator(name = "BOARD_IDX_GENERATOR" , sequenceName = "BOARD_SEQ", allocationSize = 1)
@Table(name = "board")
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BOARD_IDX_GENERATOR"
    )
    @Column(name = "BOARD_ID")
    private Long boardId; //게시글 인덱스

    @Column(length = 30)
    @NotNull
    private String title; //제목

    @Column
    @Lob // 대용량 데이터
    @NotNull
    private String content; //섬머노트 라이브러리 사용 (HTML 태그가 같이 섞여서 디자인됨)

    @ColumnDefault("0")
    private int count; // 조회수

    private String tags;

    @ColumnDefault("1")
    private boolean show;

    @ColumnDefault("0")
    private boolean del;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY) //Many = board , One = user
    @JoinColumn(name = "USER_ID")
    private User user; //DB는 오브젝트를 저장할 수 없다. FK,자바는 오브젝트를 저장할 수 있다. 여기서 충돌이 일어남.

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY) //Many = board , one = category
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @Builder
    public Board(
            String title , User user , String content , int count , Long boardId,
            String tags , boolean show , boolean del , Category category
    ){
        this.category = category;
        this.content = content;
        this.del = del;
        this.show = show;
        this.count = count;
        this.tags = tags;
        this.title = title;
        this.user = user;
        this.boardId = boardId;
    }

}
