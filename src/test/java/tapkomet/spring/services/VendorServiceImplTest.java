package tapkomet.spring.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tapkomet.spring.api.v1.mappers.VendorMapper;
import tapkomet.spring.api.v1.model.VendorDTO;
import tapkomet.spring.controllers.v1.VendorController;
import tapkomet.spring.domain.Vendor;
import tapkomet.spring.repositories.VendorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Created by Tapkomet on 6/11/2020
 */
public class VendorServiceImplTest {

    public static final String NAME = "Ikea";
    public static final long ID = 1L;
    public static final long ID2 = 2L;
    VendorService vendorService;

    public static final String URL_BASE = VendorController.VENDOR_BASE_URL + "/";

    @Mock
    VendorRepository vendorRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        vendorService = new VendorServiceImpl(VendorMapper.INSTANCE, vendorRepository);
    }

    @Test
    public void getAllVendors() {

        Vendor vendor1 = new Vendor();
        vendor1.setId(ID);

        Vendor vendor2 = new Vendor();
        vendor2.setId(ID2);

        //given
        List<Vendor> vendorList = Arrays.asList(vendor1, vendor2);

        when(vendorRepository.findAll()).thenReturn(vendorList);

        //when
        List<VendorDTO> vendorDTOList = vendorService.getAllVendors();

        //then
        assertEquals(2, vendorDTOList.size());
    }

    @Test
    public void getVendorById() {

        //given
        Vendor vendor = new Vendor();
        vendor.setId(ID);
        vendor.setName(NAME);

        when(vendorRepository.findById(anyLong())).thenReturn(Optional.of(vendor));

        //when
        VendorDTO vendorDTO = vendorService.getVendorById(ID);

        //then
        assertEquals(NAME, vendorDTO.getName());
        assertEquals(URL_BASE + ID, vendorDTO.getVendor_url());

    }

    @Test
    public void createVendor() {
        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        Vendor savedVendor = new Vendor();
        savedVendor.setId(ID);
        savedVendor.setName(vendorDTO.getName());

        when(vendorRepository.save(any(Vendor.class))).thenReturn(savedVendor);

        //when
        VendorDTO savedDTO = vendorService.createVendor(vendorDTO);

        //then
        assertEquals(vendorDTO.getName(), savedDTO.getName());
        assertEquals(URL_BASE + ID, savedDTO.getVendor_url());
    }

    @Test
    public void updateVendor() {

        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        Vendor savedVendor = new Vendor();
        savedVendor.setId(ID);
        savedVendor.setName(vendorDTO.getName());

        when(vendorRepository.save(any(Vendor.class))).thenReturn(savedVendor);

        //when
        VendorDTO savedDTO = vendorService.updateVendor(vendorDTO, ID);

        //then
        assertEquals(vendorDTO.getName(), savedDTO.getName());
        assertEquals(URL_BASE + ID, savedDTO.getVendor_url());
    }

    @Test
    public void deleteVendorById() {
        vendorRepository.deleteById(ID);

        verify(vendorRepository, times(1)).deleteById(anyLong());
    }
}