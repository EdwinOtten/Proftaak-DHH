package edu.avans.hartigehap.domain.price;

import java.util.List;

/**
 * Created by Gijs on 10-2-14.
 *
 * Default price calculator.
 */
public class DefaultPriceCalculator implements PriceCalculator {

    @Override
    public double calculatePrice(List<WebOrderItem> orderList) {
        return 0;
    }
}
