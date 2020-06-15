package tapkomet.spring.api.v1.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tapkomet.spring.api.v1.model.CustomerDTO;
import tapkomet.spring.domain.Customer;

/**
 * Created by Tapkomet on 6/11/2020
 */
@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "customer_url", source = "id")
    CustomerDTO customerToCustomerDTO(Customer customer);

    @Mapping(target = "id", ignore = true)
    Customer customerDTOToCustomer(CustomerDTO customerDTO);

    String URL_BASE = "/api/v1/customers/";

    default String urlGenerator(Long id) {
        return URL_BASE + id.toString();
    }
}