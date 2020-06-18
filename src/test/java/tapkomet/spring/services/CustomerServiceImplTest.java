package tapkomet.spring.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tapkomet.spring.api.v1.mappers.CustomerMapper;
import tapkomet.spring.api.v1.model.CustomerDTO;
import tapkomet.spring.controllers.v1.CustomerController;
import tapkomet.spring.domain.Customer;
import tapkomet.spring.repositories.CustomerRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by Tapkomet on 6/11/2020
 */
public class CustomerServiceImplTest {

    public static final String FIRST_NAME = "Joe";
    public static final String LAST_NAME = "Cotton-Eye";
    public static final long ID = 1L;
    public static final long ID2 = 2L;
    CustomerService customerService;

    public static final String URL_BASE = CustomerController.CUSTOMER_BASE_URL + "/";

    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void getAllCustomers() {

        Customer customer1 = new Customer();
        customer1.setId(ID);

        Customer customer2 = new Customer();
        customer2.setId(ID2);

        //given
        List<Customer> customerList = Arrays.asList(customer1, customer2);

        when(customerRepository.findAll()).thenReturn(customerList);

        //when
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();

        //then
        assertEquals(2, customerDTOList.size());
    }

    @Test
    public void getCustomerById() {

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(FIRST_NAME);
        customer.setLastname(LAST_NAME);

        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

        //when
        CustomerDTO customerDTO = customerService.getCustomerById(ID);

        //then
        assertEquals(FIRST_NAME, customerDTO.getFirstname());
        assertEquals(LAST_NAME, customerDTO.getLastname());
        assertEquals(URL_BASE + ID, customerDTO.getCustomer_url());

    }

    @Test
    public void createCustomer() {
        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname(FIRST_NAME);
        customerDTO.setLastname(LAST_NAME);

        Customer savedCustomer = new Customer();
        savedCustomer.setId(ID);
        savedCustomer.setFirstname(customerDTO.getFirstname());
        savedCustomer.setLastname(customerDTO.getLastname());

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        //when
        CustomerDTO savedDTO = customerService.createCustomer(customerDTO);

        //then
        assertEquals(customerDTO.getFirstname(), savedDTO.getFirstname());
        assertEquals(URL_BASE + ID, savedDTO.getCustomer_url());
    }

    @Test
    public void updateCustomer() {

        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname(FIRST_NAME);
        customerDTO.setLastname(LAST_NAME);

        Customer savedCustomer = new Customer();
        savedCustomer.setId(ID);
        savedCustomer.setFirstname(customerDTO.getFirstname());
        savedCustomer.setLastname(customerDTO.getLastname());

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        //when
        CustomerDTO savedDTO = customerService.updateCustomer(customerDTO, ID);

        //then
        assertEquals(customerDTO.getFirstname(), savedDTO.getFirstname());
        assertEquals(URL_BASE + ID, savedDTO.getCustomer_url());
    }

    @Test
    public void deleteCustomerById() {
        customerRepository.deleteById(ID);

        verify(customerRepository, times(1)).deleteById(anyLong());
    }
}