package tapkomet.spring.api.v1.mappers;

import org.junit.Test;
import tapkomet.spring.api.v1.model.VendorDTO;
import tapkomet.spring.controllers.v1.VendorController;
import tapkomet.spring.domain.Vendor;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tapkomet on 6/16/2020
 */
public class VendorMapperTest {

    public static final String NAME = "Ikea";
    public static final long ID = 1L;

    public static final String URL_BASE = VendorController.VENDOR_BASE_URL + "/";

    VendorMapper vendorMapper = VendorMapper.INSTANCE;

    @Test
    public void vendorToVendorDTO() throws Exception {

        //given
        Vendor vendor = new Vendor();
        vendor.setId(ID);
        vendor.setName(NAME);

        //when
        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);

        //then
        assertEquals(NAME, vendorDTO.getName());
        assertEquals(URL_BASE + ID, vendorDTO.getVendor_url());
    }

}