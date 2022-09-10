package project.app.polstory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import project.app.polstory.entity.User;

public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {

}
