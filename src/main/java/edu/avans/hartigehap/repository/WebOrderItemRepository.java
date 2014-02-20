package edu.avans.hartigehap.repository;

import edu.avans.hartigehap.domain.WebOrderItem;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Edwin Otten
 */
public interface WebOrderItemRepository extends PagingAndSortingRepository<WebOrderItem, Long> {
}
