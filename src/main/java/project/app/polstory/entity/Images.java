package project.app.polstory.entity;

import lombok.Builder;
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
    private long imageIdx;

    private Long boardIdx;
    private String orgName;
    private String stdName;
    private String imageSize;
    private Boolean del;

    @Builder
    public Images(
            Long imageIdx , Long boardIdx , String orgName ,
            String stdName , String imageSize , Boolean del
    ){
        this.boardIdx = boardIdx;
        this.del = del;
        this.imageIdx = imageIdx;
        this.orgName = orgName;
        this.stdName = stdName;
        this.imageSize = imageSize;
    }

}
