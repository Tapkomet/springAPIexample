package tapkomet.spring.services;

import tapkomet.spring.api.v1.model.CategoryDTO;

import java.util.List;

/**
 * Created by Tapkomet on 6/11/2020
 */
public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
