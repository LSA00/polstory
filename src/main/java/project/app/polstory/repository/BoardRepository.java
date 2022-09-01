package project.app.polstory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.app.polstory.entity.Board;

public interface BoardRepository extends JpaRepository<Board , Long> {


}
