package edu.avans.hartigehap.web.controller;

import edu.avans.hartigehap.domain.FoodCategory;
import edu.avans.hartigehap.domain.Meal;
import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.service.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = {"/","/webmenu"}, method = RequestMethod.GET)
    public String listPizzaOverview(Model uiModel) {
        Page<MenuItem> pizzaList = menuItemService.findByFoodCategoriesIdPaginated(8L, 0);

        uiModel.addAttribute("pizzaList", pizzaList.getContent());

        return "hartigehap/listpizzas";
    }




}
