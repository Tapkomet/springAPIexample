package tapkomet.spring.api.v1.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tapkomet.spring.api.v1.model.CustomerDTO;
import tapkomet.spring.domain.Customer;

import static tapkomet.spring.controllers.v1.CustomerController.CUSTOMER_BASE_URL;

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


    default String urlGenerator(Long id) {
        return CUSTOMER_BASE_URL + "/" + id.toString();
    }
}