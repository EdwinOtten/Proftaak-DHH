package edu.avans.hartigehap.domain.price;

import edu.avans.hartigehap.domain.WebOrderItem;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

/**
 * Created by Gijs on 10-2-14.
 *
 * Uses highest price as discount
 */
public class HighestPriceDiscountPriceCalculator extends DefaultPriceCalculator {

    @Override
    public BigDecimal calculatePrice(Collection<WebOrderItem> orderList) {
        BigDecimal price = super.calculatePrice(orderList);
        BigDecimal highestPrice = BigDecimal.ZERO;

        for (WebOrderItem item : orderList) {
            // if getPrice is bigger than current highest price
            if (highestPrice.compareTo(item.getPrice()) == -1) {
                highestPrice = item.getPrice();
            }
        }

        // No discount if only one item has been added to the basket!
        if (orderList.size() > 1) {
            price = price.subtract(highestPrice);
        }

        return price;
    }
}
