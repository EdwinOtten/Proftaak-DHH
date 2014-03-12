package edu.avans.hartigehap.domain.price;


import edu.avans.hartigehap.domain.Meal;
import edu.avans.hartigehap.domain.WebOrderItem;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gijs on 25-2-14.
 */
public class PriceCalculatorTest {

    private Collection<WebOrderItem> items;


    private void setUp() {

        Meal meal1 = new Meal();
        meal1.setPrice(4);

        Meal meal2 = new Meal();
        meal2.setPrice(6);

        WebOrderItem item1 = new WebOrderItem();
        item1.setMenuItem(meal1);

        WebOrderItem item2 = new WebOrderItem();
        item2.setMenuItem(meal2);

        items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
    }


    @Test
    public void testDefaultCalculator() {

        setUp();
        PriceCalculator calculator = new DefaultPriceCalculator();
        BigDecimal price = calculator.calculatePrice(items);

        assertEquals("price", new BigDecimal("10"), price);
    }

    @Test
    public void testHighestPriceDiscountCalculator() {

        setUp();
        PriceCalculator calculator = new HighestPriceDiscountPriceCalculator();
        BigDecimal price = calculator.calculatePrice(items);

        assertEquals("HighestPrice", new BigDecimal("4"), price);
    }

    @Test
    public void testPercentageDiscountCalculator() {
        setUp();

        PriceCalculator calculator = new PercentageDiscountPriceCalculator("0.80");
        BigDecimal price = calculator.calculatePrice(items);

        assertEquals("PercentageCalculator", new BigDecimal("8.00"),price);
    }

    @Test
    public void testPercentageDiscountCalculatorException() {

        try {
            PriceCalculator calculator = new PercentageDiscountPriceCalculator();
        } catch (IllegalArgumentException e){
            assertTrue("Expected exception has been thrown", true);
            return;
        }

        assertTrue("Expected exception has not been thrown", false);
    }



}
