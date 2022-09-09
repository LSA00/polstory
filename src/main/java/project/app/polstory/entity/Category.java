package project.app.polstory.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID")
    private long categoryId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID" , referencedColumnName = "USER_ID")
    private User user;
    private String categoryName;

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    List<Board> boardList = new ArrayList<>();

    @Builder
    public Category(User user , Long categoryId, String categoryName){
        this.user = user;
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }


}
