package edu.avans.hartigehap.domain.price;

import edu.avans.hartigehap.domain.WebOrderItem;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

/**
 * Created by Gijs on 10-2-14.
 *
 * calculates discount based on percentage.
 */
public class PercentageDiscountPriceCalculator extends DefaultPriceCalculator {

    /**
     * Discount given on products
     *
     */
    private String discount;


    /**
     * Constructor
     *
     * @param discount  A percentage which should be multiplied with the base price to
     *                  get the discount you want.
     *
     *                  Passing 0.80 as parameter gives the customer a discount of 20%
     */
    public PercentageDiscountPriceCalculator(String discount) {
        this.discount = discount;
    }


    /**
     * Constructor
     */
    public PercentageDiscountPriceCalculator(){
        throw new IllegalArgumentException("Expected discount percentage parameter - none given");
    }

    @Override
    public BigDecimal calculatePrice(Collection<WebOrderItem> orderList) {
        BigDecimal price = super.calculatePrice(orderList);

        return price.multiply(new BigDecimal(discount));
    }
}
