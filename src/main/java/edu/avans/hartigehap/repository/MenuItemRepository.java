package edu.avans.hartigehap.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import edu.avans.hartigehap.domain.MenuItem;

import java.util.List;

public interface MenuItemRepository extends PagingAndSortingRepository<MenuItem, String> {

    List<MenuItem> findByFoodCategory(String category);
}