package project.app.polstory.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "BOARDIDX_SEQ_GENERATOR" , sequenceName = "BOARDIDX_SEQ", initialValue = 1)
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long boardIdx;

    //@JoinColumn(name = "memIdx")
    private Long memIdx;
    private String boardContent;
    private String boardTitle;
    private String boardTags;
    private Date boardDate;
    private Boolean boardShow;
    private int cateNum;

    @Builder
    public Board(
            Long memIdx, Long boardIdx, String boardContent,
            String boardTitle , String boardTags, Boolean boardShow, int cateNum, Date boardDate){
        this.boardContent = boardContent;
        this.boardTags = boardTags;
        this.boardDate = boardDate;
        this.boardShow = boardShow;
        this.cateNum = cateNum;
        this.boardTitle = boardTitle;
        this.memIdx = memIdx;
        this.boardIdx = boardIdx;
    }

}
