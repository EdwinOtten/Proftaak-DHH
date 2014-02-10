package edu.avans.hartigehap.domain.price;

import edu.avans.hartigehap.domain.WebOrderItem;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Gijs on 10-2-14.
 */
public class PercentageDiscountPriceCalculator extends DefaultPriceCalculator {

    @Override
    public BigDecimal calculatePrice(List<WebOrderItem> orderList) {
        return super.calculatePrice(orderList); /* do something with percentage here */
    }
}
