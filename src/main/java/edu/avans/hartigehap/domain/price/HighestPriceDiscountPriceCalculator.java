package edu.avans.hartigehap.domain.price;

import edu.avans.hartigehap.domain.WebOrderItem;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Gijs on 10-2-14.
 *
 * Uses highest price as discount
 */
public class HighestPriceDiscountPriceCalculator extends DefaultPriceCalculator {

    @Override
    public BigDecimal calculatePrice(List<WebOrderItem> orderList) {
        BigDecimal price = super.calculatePrice(orderList);
        BigDecimal highestPrice = BigDecimal.ZERO;

        for (WebOrderItem item : orderList) {
            // if getPrice is bigger than current highest price
            if (highestPrice.compareTo(item.getPrice()) == -1) {
                highestPrice = item.getPrice();
            }
        }

        price = price.subtract(highestPrice);

        return price;
    }
}
