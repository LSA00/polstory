package project.app.polstory.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@DynamicInsert
@SequenceGenerator(name = "BOARD_IDX_GENERATOR" , sequenceName = "BOARD_SEQ", allocationSize = 1)
@Table(name = "board")
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BOARD_IDX_GENERATOR"
    )
    private Long boardIdx;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ToString.Exclude
    private User user;
    private String boardContent;
    private String boardTitle;
    private String boardTags;
    @ColumnDefault("1")
    private Boolean boardShow;
    @ColumnDefault("0")
    private Integer cateNum;

    public void setUser(User user) {
        this.user = user;
    }

    @Builder
    public Board(
            User user, Long boardIdx, String boardContent,
            String boardTitle , String boardTags, boolean boardShow, Integer cateNum){
        this.boardContent = boardContent;
        this.boardTags = boardTags;
        this.boardShow = boardShow;
        this.cateNum = cateNum;
        this.boardTitle = boardTitle;
        this.user = user;
        this.boardIdx = boardIdx;
    }

}
