package edu.avans.hartigehap.service.jpa;

import edu.avans.hartigehap.domain.FoodCategory;
import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.repository.MenuItemRepository;
import edu.avans.hartigehap.service.MenuItemService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Gijs on 14-2-14.
 */

@Repository
public class MenuItemServiceImpl implements MenuItemService{

    private static final int ITEMS_PER_PAGE = 3;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public List<MenuItem> findByFoodCategoriesId(long pizzaId) {
        return menuItemRepository.findByFoodCategoriesId(pizzaId);
    }

    /**
     * Finds MenuItems with Pagination support
     *
     * @param pizzaId
     * @param pageIndex
     * @return MenuItems list
     */
    @Override
    public Page<MenuItem> findByFoodCategoriesIdPaginated(long pizzaId, int pageIndex) {

        Page<MenuItem> requestedPage = menuItemRepository.findByFoodCategoriesId(pizzaId, constructPageSpecification(pageIndex));

        return requestedPage;
    }

    /**
     * Constructs Pageable object
     *
     * @param pageIndex
     * @return Pageable
     */
    private Pageable constructPageSpecification(int pageIndex) {
        return new PageRequest(pageIndex, ITEMS_PER_PAGE);
    }

    @Override
	public MenuItem findOne(String name) {
		return menuItemRepository.findOne(name);
	}
}
