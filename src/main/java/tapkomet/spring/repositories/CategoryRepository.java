package tapkomet.spring.repositories;

import tapkomet.spring.api.v1.model.CategoryDTO;
import tapkomet.spring.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
