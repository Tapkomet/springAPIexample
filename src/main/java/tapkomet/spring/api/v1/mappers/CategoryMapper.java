package tapkomet.spring.api.v1.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tapkomet.spring.api.v1.model.CategoryDTO;
import tapkomet.spring.domain.Category;

/**
 * Created by Tapkomet on 6/10/2020
 */
@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "id", target = "id")
    CategoryDTO categoryToCategoryDTO(Category category);
}
