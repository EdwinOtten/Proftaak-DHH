package edu.avans.hartigehap.service;


import edu.avans.hartigehap.domain.MenuItem;

import java.util.List;
/**
 * Created by Gijs on 14-2-14.
 */
public interface MenuItemService {

    public static final String PIZZA = "pizza";

    List<MenuItem> findByFoodCategory(String category);
}
