package tapkomet.spring.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import tapkomet.spring.api.v1.mappers.CustomerMapper;
import tapkomet.spring.api.v1.model.CustomerDTO;
import tapkomet.spring.bootstrap.Bootstrap;
import tapkomet.spring.domain.Customer;
import tapkomet.spring.repositories.CategoryRepository;
import tapkomet.spring.repositories.CustomerRepository;
import tapkomet.spring.repositories.VendorRepository;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Tapkomet on 6/15/2020
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerServiceImplIT {

    String UPDATED = "Updated";

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    VendorRepository vendorRepository;

    CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        Bootstrap bootstrap = new Bootstrap(categoryRepository, customerRepository, vendorRepository);
        bootstrap.run();

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void patchCustomerUpdateFirstName() throws Exception {
        Long id = getCustomerIdValue();
        Customer customer = customerRepository.getOne(id);

        assertNotNull(customer);

        String originalFirstName = customer.getFirstname();
        String originalLastName = customer.getLastname();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname(UPDATED);

        customerService.patchCustomer(customerDTO, id);

        Customer updatedCustomer = customerRepository.findById(id).get();

        assertNotNull(updatedCustomer);
        assertEquals(UPDATED, updatedCustomer.getFirstname());
        assert(!originalFirstName.equals(updatedCustomer.getFirstname()));
        assertEquals(originalLastName, updatedCustomer.getLastname());
    }

    @Test
    public void patchCustomerUpdateLastName() throws Exception {
        Long id = getCustomerIdValue();
        Customer customer = customerRepository.getOne(id);

        assertNotNull(customer);

        String originalLastName = customer.getLastname();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setLastname(UPDATED);

        customerService.patchCustomer(customerDTO, id);

        Customer updatedCustomer = customerRepository.findById(id).get();

        assertNotNull(updatedCustomer);
        assertEquals(UPDATED, updatedCustomer.getLastname());
        assert(!originalLastName.equals(updatedCustomer.getLastname()));
    }

    private Long getCustomerIdValue() {
        List<Customer> customers = customerRepository.findAll();

        return customers.get(0).getId();
    }
}
