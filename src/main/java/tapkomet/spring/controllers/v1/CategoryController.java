package tapkomet.spring.controllers.v1;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tapkomet.spring.api.v1.model.CategoryDTO;
import tapkomet.spring.api.v1.model.CategoryListDTO;
import tapkomet.spring.services.CategoryService;

/**
 * Created by Tapkomet on 6/11/2020
 */
@Controller
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<CategoryListDTO> getAllCategories() {

        return new ResponseEntity<CategoryListDTO>
                (new CategoryListDTO(categoryService.getAllCategories()), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name) {

        return new ResponseEntity<CategoryDTO>
                (categoryService.getCategoryByName(name), HttpStatus.OK);
    }
}
