package tapkomet.spring.services;

import tapkomet.spring.api.v1.model.CategoryDTO;
import tapkomet.spring.api.v1.model.CustomerDTO;

import java.util.List;

/**
 * Created by Tapkomet on 6/11/2020
 */
public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id);
}
