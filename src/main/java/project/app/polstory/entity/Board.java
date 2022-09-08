package project.app.polstory.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "BOARDIDX_SEQ_GENERATOR" , sequenceName = "BOARDIDX_SEQ")
@Table(name = "board")
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long boardIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private User user;
    private String boardContent;
    private String boardTitle;
    private String boardTags;
    private Boolean boardShow;
    private int cateNum;

    @Builder
    public Board(
            User user, Long boardIdx, String boardContent,
            String boardTitle , String boardTags, boolean boardShow, int cateNum){
        this.boardContent = boardContent;
        this.boardTags = boardTags;
        this.boardShow = boardShow;
        this.cateNum = cateNum;
        this.boardTitle = boardTitle;
        this.user = user;
        this.boardIdx = boardIdx;
    }

}
