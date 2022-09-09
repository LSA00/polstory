package project.app.polstory.entity;

import lombok.Builder;
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
    private long fileIdx;

    private Long boardIdx;
    private String orgName;
    private String stdName;
    private String imageSize;
    private Boolean del;

    @Builder
    public Files(
            Long fileIdx , Long boardIdx , String orgName ,
            String stdName , String imageSize , Boolean del
    ){
        this.boardIdx = boardIdx;
        this.del = del;
        this.fileIdx = fileIdx;
        this.orgName = orgName;
        this.stdName = stdName;
        this.imageSize = imageSize;
    }

}