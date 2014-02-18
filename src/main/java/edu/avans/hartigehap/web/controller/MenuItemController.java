package edu.avans.hartigehap.web.controller;

import edu.avans.hartigehap.domain.FoodCategory;
import edu.avans.hartigehap.domain.Meal;
import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.service.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gijs on 14-2-14.
 */

@Controller
public class MenuItemController {

    final Logger logger = LoggerFactory.getLogger(MenuItemController.class);

    @Autowired
    private MenuItemService menuItemService;

    // mapping to "/" is not RESTful, but is for bootstrapping!
    @RequestMapping(value = {"/webwinkel/overzicht"}, method = RequestMethod.GET)
    public String listPizzaOverview(Model uiModel) {

       List<MenuItem> pizzaList = menuItemService.findByFoodCategoriesId(8L);


        uiModel.addAttribute("pizzaList", pizzaList);


        return "hartigehap/listpizzas";
    }
}
