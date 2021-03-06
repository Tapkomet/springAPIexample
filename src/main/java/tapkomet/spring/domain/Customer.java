package tapkomet.spring.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Tapkomet on 6/11/2020
 */
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //variable names not following Java camelCase convention to align with target API names
    private Long id;
    private String firstname;
    private String lastname;
}