package project.app.polstory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.app.polstory.entity.Images;

public interface ImagesRepository extends JpaRepository<Images , Long> {
}
