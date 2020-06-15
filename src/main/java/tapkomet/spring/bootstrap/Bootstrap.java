package tapkomet.spring.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tapkomet.spring.domain.Category;
import tapkomet.spring.domain.Customer;
import tapkomet.spring.repositories.CategoryRepository;
import tapkomet.spring.repositories.CustomerRepository;

/**
 * Created by Tapkomet on 6/10/2020
 */
@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Data Loaded = " + categoryRepository.count());


        Customer jill = new Customer();
        jill.setFirstname("Jill");
        jill.setLastname("Harris");

        Customer jake = new Customer();
        jake.setFirstname("Jake");
        jake.setLastname("Sullivan");

        Customer john = new Customer();
        john.setFirstname("John");
        john.setLastname("Jackson");

        Customer adam = new Customer();
        adam.setFirstname("Adam");
        adam.setLastname("Smith");

        Customer luther = new Customer();
        luther.setFirstname("Luther");
        luther.setLastname("Huss");

        customerRepository.save(jill);
        customerRepository.save(jake);
        customerRepository.save(john);
        customerRepository.save(adam);
        customerRepository.save(luther);

        System.out.println("Data Loaded = " + customerRepository.count());

    }
}
