package edu.avans.hartigehap.domain.weborder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import edu.avans.hartigehap.domain.DomainObject;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by David-Paul on 10-2-14.
 */
@Entity
//optional
@Table(name = "WEBCUSTOMER")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter
@Setter
public class WebCustomer extends DomainObject {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;

    @NotNull
    @Size(min=2, max=40)
    private String name;

    @NotNull
    @Size(min=2, max=40)
    private String address;


    @NotNull
    @Size(min=2, max=40)
    private String city;
}
