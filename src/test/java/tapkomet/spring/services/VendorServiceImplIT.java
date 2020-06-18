package tapkomet.spring.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import tapkomet.spring.api.v1.mappers.VendorMapper;
import tapkomet.spring.api.v1.model.VendorDTO;
import tapkomet.spring.bootstrap.Bootstrap;
import tapkomet.spring.domain.Vendor;
import tapkomet.spring.repositories.CategoryRepository;
import tapkomet.spring.repositories.CustomerRepository;
import tapkomet.spring.repositories.VendorRepository;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Tapkomet on 6/16/2020
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class VendorServiceImplIT {

    String UPDATED = "Updated";

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    VendorRepository vendorRepository;


    VendorService vendorService;

    @Before
    public void setUp() throws Exception {
        Bootstrap bootstrap = new Bootstrap(categoryRepository, customerRepository, vendorRepository);
        bootstrap.run();

        vendorService = new VendorServiceImpl(VendorMapper.INSTANCE, vendorRepository);
    }

    @Test
    public void patchVendorUpdatetName() throws Exception {
        Long id = getVendorIdValue();
        Vendor vendor = vendorRepository.getOne(id);

        assertNotNull(vendor);

        String originalFirstName = vendor.getName();

        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(UPDATED);

        vendorService.patchVendor(vendorDTO, id);

        Vendor updatedVendor = vendorRepository.findById(id).get();

        assertNotNull(updatedVendor);
        assertEquals(UPDATED, updatedVendor.getName());
        assert (!originalFirstName.equals(updatedVendor.getName()));
    }


    private Long getVendorIdValue() {
        List<Vendor> vendors = vendorRepository.findAll();

        return vendors.get(0).getId();
    }
}
