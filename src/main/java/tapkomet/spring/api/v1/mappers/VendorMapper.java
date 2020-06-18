package tapkomet.spring.api.v1.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tapkomet.spring.api.v1.model.VendorDTO;
import tapkomet.spring.domain.Vendor;

import static tapkomet.spring.controllers.v1.VendorController.VENDOR_BASE_URL;

/**
 * Created by Tapkomet on 6/16/2020
 */
@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    @Mapping(target = "vendor_url", source = "id")
    VendorDTO vendorToVendorDTO(Vendor vendor);

    @Mapping(target = "id", ignore = true)
    Vendor vendorDTOToVendor(VendorDTO vendorDTO);


    default String urlGenerator(Long id) {
        return VENDOR_BASE_URL + "/" + id.toString();
    }
}