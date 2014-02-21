package edu.avans.hartigehap.domain.weborder;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import edu.avans.hartigehap.domain.DomainObject;
import edu.avans.hartigehap.domain.WebOrderItem;
import edu.avans.hartigehap.domain.price.PriceCalculator;
import edu.avans.hartigehap.domain.price.PriceCalculatorFactory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by David-Paul on 10-2-14.
 * States: new, in progress, payed.
 */
@Entity
//optional
@Table(name = "WEBORDER")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter
@Setter
//@ToString(callSuper=true, includeFieldNames=true, of= {"billStatus", "currentOrder", "orders"})
public class WebOrder extends DomainObject {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
    @Transient
    private PriceCalculator priceCalculator;
    @OneToOne
    private WebCustomer customer;

    @Column(name="state")
    private WebOrderState webOrderState;
    @OneToMany(mappedBy = "webOrder")
    private Collection<WebOrderItem> webOrderItems;

    public enum WebOrderState {
        NEW, PAID
    }

    public void finishWebOrder() {
        setWebOrderState(WebOrderState.PAID);
    }

    public void addWebOrderItem(WebOrderItem webOrderItem) {
        webOrderItems.add(webOrderItem);
    }

    public void removeWebOrderItem(WebOrderItem webOrderItem) {
        webOrderItems.remove(webOrderItem);
    }

}

