package edu.avans.hartigehap.domain.price;

import edu.avans.hartigehap.domain.WebOrderItem;

import java.util.List;

/**
 * Created by Gijs on 10-2-14.
 */
public class PercentageDiscountPriceCalculator extends DefaultPriceCalculator {

    @Override
    public double calculatePrice(List<WebOrderItem> orderList) {
        return super.calculatePrice(orderList) * 0.25;
    }
}
