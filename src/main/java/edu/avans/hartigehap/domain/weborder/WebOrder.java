package edu.avans.hartigehap.domain.weborder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import edu.avans.hartigehap.domain.PriceCalculator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

/**
 * Created by David-Paul on 10-2-14.
 * States: new, in progress, payed.
 */
@Entity
//optional
@Table(name = "WEBORDERS")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter
@Setter
//@ToString(callSuper=true, includeFieldNames=true, of= {"billStatus", "currentOrder", "orders"})
public class WebOrder {
    private PriceCalculator priceCalculator;
    private Customer customer;
    private ArrayList<WebOrderItem> webOrderItems;
    private enum state {
        NEW, IN_PROGRESS, PAYED;
    }

    public WebOrder(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }
}
