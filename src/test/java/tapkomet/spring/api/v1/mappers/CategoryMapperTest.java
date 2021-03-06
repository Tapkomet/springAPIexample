package tapkomet.spring.api.v1.mappers;

import org.junit.Test;
import tapkomet.spring.api.v1.model.CategoryDTO;
import tapkomet.spring.domain.Category;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tapkomet on 6/11/2020
 */
public class CategoryMapperTest {

    public static final String NAME = "Joe";
    public static final long ID = 1L;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() throws Exception {

        //given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //then
        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }

}