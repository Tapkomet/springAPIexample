package tapkomet.spring.services;

import org.springframework.stereotype.Service;
import tapkomet.spring.api.v1.mappers.VendorMapper;
import tapkomet.spring.api.v1.model.VendorDTO;
import tapkomet.spring.domain.Vendor;
import tapkomet.spring.repositories.VendorRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tapkomet on 6/16/2020
 */
@Service
public class VendorServiceImpl implements VendorService {

    private final VendorMapper vendorMapper;
    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
        this.vendorMapper = vendorMapper;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(vendorMapper::vendorToVendorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorMapper.vendorToVendorDTO(vendorRepository.findById(id).get());
    }

    @Override
    public VendorDTO createVendor(VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
        return createOrUpdate(vendor);
    }

    @Override
    public VendorDTO updateVendor(VendorDTO vendorDTO, Long id) {
        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
        vendor.setId(id);
        return createOrUpdate(vendor);
    }

    private VendorDTO createOrUpdate(Vendor vendor) {
        Vendor savedVendor = vendorRepository.save(vendor);

        return vendorMapper.vendorToVendorDTO(savedVendor);
    }

    @Override
    public VendorDTO patchVendor(VendorDTO vendorDTO, Long id) {
        return vendorRepository.findById(id).map(vendor -> {
            vendor.setName(vendorDTO.getName());
            return vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
        }).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteVendorById(Long id) {
        vendorRepository.deleteById(id);
    }


}
