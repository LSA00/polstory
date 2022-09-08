package project.app.polstory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import project.app.polstory.entity.Board;

public interface BoardRepository extends JpaRepository<Board , Long>, QuerydslPredicateExecutor<Board> {

}
