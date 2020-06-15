package tapkomet.spring.api.v1.mappers;

import org.junit.Test;
import tapkomet.spring.api.v1.model.CustomerDTO;
import tapkomet.spring.domain.Customer;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tapkomet on 6/11/2020
 */
public class CustomerMapperTest {

    public static final String FIRST_NAME = "Joe";
    public static final String LAST_NAME = "Cotton-Eye";
    public static final long ID = 1L;

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() throws Exception {

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(FIRST_NAME);
        customer.setLastname(LAST_NAME);

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(FIRST_NAME, customerDTO.getFirstname());
        assertEquals(LAST_NAME, customerDTO.getLastname());
        assertEquals(CustomerMapper.URL_BASE + ID, customerDTO.getCustomer_url());
    }

}