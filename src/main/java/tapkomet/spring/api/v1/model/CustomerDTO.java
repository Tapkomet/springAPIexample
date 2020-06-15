package tapkomet.spring.api.v1.model;

import lombok.Data;

/**
 * Created by Tapkomet on 6/11/2020
 */
@Data
public class CustomerDTO {
    //variable names not following Java camelCase convention to align with target API names
    private String firstname;
    private String lastname;
    private String customer_url;
}
