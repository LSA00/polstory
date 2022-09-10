package project.app.polstory.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "files")
@NoArgsConstructor
@SequenceGenerator(name = "FILE_IDX_GENERATOR" , sequenceName = "FILE_IDX" , allocationSize = 1)
public class Files extends BaseEntity{

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "FILE_IDX_GENERATOR"
    )
    private long fileId;
    private String orgName;
    private String stdName;
    private boolean del;

    @ManyToOne(fetch = FetchType.LAZY) //Many = files , one = board
    @JoinColumn(name = "BOARD_ID")
    private Board board;

}