package project.app.polstory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.app.polstory.entity.Files;

public interface ImagesRepository extends JpaRepository<Files , Long> {
}
