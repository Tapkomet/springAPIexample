package tapkomet.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tapkomet.spring.domain.Customer;

/**
 * Created by Tapkomet on 6/11/2020
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
