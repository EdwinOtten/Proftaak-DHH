package edu.avans.hartigehap.domain.price;

import edu.avans.hartigehap.domain.WebOrderItem;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

/**
 * Created by Gijs on 10-2-14.
 *
 * Default price calculator.
 */
public class DefaultPriceCalculator implements PriceCalculator {

    @Override
    public BigDecimal calculatePrice(Collection<WebOrderItem> orderList) {
        BigDecimal price = BigDecimal.ZERO;

        for (WebOrderItem item : orderList) {
            price = price.add(item.getPrice());
        }

        return price;
    }


}
