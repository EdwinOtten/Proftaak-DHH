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

    /**
     * Constructor
     *
     * Prevents avoiding the singleton due to the method being private.
     */
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
        PriceCalculator calculator = null;

        switch (dayOfWeek) {
            // Fall-trough, break omitted on purpose.
            case Calendar.MONDAY:
            case Calendar.TUESDAY:
            case Calendar.WEDNESDAY:
            case Calendar.THURSDAY:
                calculator = new HighestPriceDiscountPriceCalculator();
                break;
            case Calendar.FRIDAY:
            case Calendar.SATURDAY:
            case Calendar.SUNDAY:
                calculator = new PercentageDiscountPriceCalculator();
                break;
            default:
                calculator = new DefaultPriceCalculator();
                break;

        }

        return calculator;
    }
}
