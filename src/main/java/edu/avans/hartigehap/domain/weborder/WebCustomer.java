package edu.avans.hartigehap.domain.weborder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import edu.avans.hartigehap.domain.DomainObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String city;
}
