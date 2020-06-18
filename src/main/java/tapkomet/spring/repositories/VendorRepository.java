package tapkomet.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tapkomet.spring.domain.Vendor;

/**
 * Created by Tapkomet on 6/16/2020
 */
public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
