package edu.avans.hartigehap.service.jpa;

import edu.avans.hartigehap.domain.FoodCategory;
import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.repository.MenuItemRepository;
import edu.avans.hartigehap.service.MenuItemService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Gijs on 14-2-14.
 */

@Repository
public class MenuItemServiceImpl implements MenuItemService{

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public List<MenuItem> findByFoodCategoriesId(long pizzaId) {
        return menuItemRepository.findByFoodCategoriesId(pizzaId);
    }

	@Override
	public MenuItem findOne(String name) {
		return menuItemRepository.findOne(name);
	}
}
