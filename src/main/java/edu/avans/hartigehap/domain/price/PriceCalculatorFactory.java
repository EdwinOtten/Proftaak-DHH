package edu.avans.hartigehap.domain.price;

import java.util.Calendar;

/**
 * Created by Gijs on 10-2-14.
 */
public class PriceCalculatorFactory {

    /**
     * Singleton Implementation
     */
    private static PriceCalculatorFactory instance;

    private PriceCalculatorFactory() {}

    /**
     * Implementation of the Singleton design pattern
     *
     * @return PriceCalculatorFactory
     */
    public static synchronized PriceCalculatorFactory getInstance() {
        if (instance == null) {
            instance = new PriceCalculatorFactory();
        }
        return instance;
    }


    /**
     * Creates a priceCalculator based on the day of the week
     *
     * @return PriceCalculator
     */
    public PriceCalculator create() {

        int dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        if

    }
}
