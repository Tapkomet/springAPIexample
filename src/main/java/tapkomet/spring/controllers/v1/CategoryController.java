package tapkomet.spring.controllers.v1;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tapkomet.spring.api.v1.model.CategoryDTO;
import tapkomet.spring.api.v1.model.CategoryListDTO;
import tapkomet.spring.services.CategoryService;

/**
 * Created by Tapkomet on 6/11/2020
 */
@RestController
@RequestMapping(CategoryController.CATEGORY_BASE_URL)
public class CategoryController {

    public static final String CATEGORY_BASE_URL = "/api/v1/categories";

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories() {

        return new CategoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name) {

        return categoryService.getCategoryByName(name);
    }
}
