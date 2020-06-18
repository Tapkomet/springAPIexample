package tapkomet.spring.services;

import tapkomet.spring.api.v1.model.VendorDTO;

import java.util.List;

/**
 * Created by Tapkomet on 6/16/2020
 */
public interface VendorService {

    List<VendorDTO> getAllVendors();

    VendorDTO getVendorById(Long id);

    VendorDTO createVendor(VendorDTO vendorDTO);

    VendorDTO updateVendor(VendorDTO vendorDTO, Long id);

    VendorDTO patchVendor(VendorDTO vendorDTO, Long id);

    void deleteVendorById(Long id);
}
