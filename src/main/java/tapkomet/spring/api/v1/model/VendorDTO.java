package tapkomet.spring.api.v1.model;

import lombok.Data;

/**
 * Created by Tapkomet on 6/16/2020
 */
@Data
public class VendorDTO {
    //variable names not following Java camelCase convention to align with target API names
    private String name;
    private String vendor_url;
}
