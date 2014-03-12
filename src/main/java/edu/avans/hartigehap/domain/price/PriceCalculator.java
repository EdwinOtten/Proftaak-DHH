package edu.avans.hartigehap.domain.price;

import edu.avans.hartigehap.domain.WebOrderItem;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

/**
 * Created by Gijs on 10-2-14.
 *
 * Classes implementing this interface are responsible for the price and
 * discount calculation.
 */
public interface PriceCalculator {

    /**
     * Calculates the total price of the weborder
     *
     * @param orderList     The ordered items.
     * @return BigDecimal       The price
     */
    BigDecimal calculatePrice(Collection<WebOrderItem> orderList);
}
