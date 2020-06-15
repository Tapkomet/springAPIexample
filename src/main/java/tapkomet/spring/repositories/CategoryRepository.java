package tapkomet.spring.repositories;

import tapkomet.spring.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tapkomet on 6/11/2020
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
