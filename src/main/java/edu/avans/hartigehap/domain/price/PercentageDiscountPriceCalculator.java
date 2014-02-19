package edu.avans.hartigehap.domain.price;

import edu.avans.hartigehap.domain.WebOrderItem;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Gijs on 10-2-14.
 *
 * calculates discount based on percentage.
 */
public class PercentageDiscountPriceCalculator extends DefaultPriceCalculator {


    @Override
    public BigDecimal calculatePrice(List<WebOrderItem> orderList) {

        BigDecimal price = super.calculatePrice(orderList);
        price.multiply(new BigDecimal(0.80));

        return price;
    }
}
