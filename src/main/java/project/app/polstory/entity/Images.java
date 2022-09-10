package project.app.polstory.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "images")
@NoArgsConstructor
@SequenceGenerator(name = "IMAGE_IDX_GENERATOR" , sequenceName = "IMAGE_IDX" , allocationSize = 1)
public class Images extends BaseEntity{

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "IMAGE_IDX_GENERATOR"
    )
    private long imageId;
    private String orgName;
    private String stdName;
    private boolean del;

    @ManyToOne(fetch = FetchType.LAZY) //Many = files , one = board
    @JoinColumn(name = "BOARD_ID")
    private Board board;

}
