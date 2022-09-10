package project.app.polstory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import project.app.polstory.entity.Board;

//DAO , JpaRepository = 기본적으로 Bean 으로 등록되어있음.
//@Repository 생략 가능.
public interface BoardRepository extends JpaRepository<Board , Long>, QuerydslPredicateExecutor<Board> {

}
