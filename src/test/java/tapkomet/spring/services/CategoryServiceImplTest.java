package tapkomet.spring.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tapkomet.spring.api.v1.model.CategoryDTO;
import tapkomet.spring.domain.Category;
import tapkomet.spring.api.v1.mappers.CategoryMapper;
import tapkomet.spring.repositories.CategoryRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CategoryServiceImplTest {

    public static final String NAME = "Joe";
    public static final long ID = 1L;
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }

    @Test
    public void getAllCategories() throws Exception {

        //given
        List<Category> categoryList = Arrays.asList(new Category(), new Category());

        when(categoryRepository.findAll()).thenReturn(categoryList);

        //when
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();

        //then
        assertEquals(2, categoryDTOList.size());
    }

    @Test
    public void getCategoryByName() throws Exception {

        //given
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        when(categoryRepository.findByName(anyString())).thenReturn(category);

        //when
        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);

        //then
        assert (ID == categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());

    }
}