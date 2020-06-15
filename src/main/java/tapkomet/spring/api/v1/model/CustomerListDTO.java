package tapkomet.spring.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Tapkomet on 6/11/2020
 */
@Data
@AllArgsConstructor
public class CustomerListDTO {
    List<CustomerDTO> customerDTOList;
}
