package edu.avans.hartigehap.repository;

import edu.avans.hartigehap.domain.FoodCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import edu.avans.hartigehap.domain.MenuItem;

import java.util.List;

public interface MenuItemRepository extends PagingAndSortingRepository<MenuItem, String> {

    List<MenuItem> findByFoodCategoriesId(long pizzaId);

    Page<MenuItem> findByFoodCategoriesId(long pizzaId, Pageable page);
}