package project.app.polstory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.app.polstory.entity.Category;

public interface CategoryRepository extends JpaRepository<Category , Long> {
}
