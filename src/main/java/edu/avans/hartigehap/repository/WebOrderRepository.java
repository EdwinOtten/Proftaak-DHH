package edu.avans.hartigehap.repository;

import edu.avans.hartigehap.domain.WebOrderItem;
import edu.avans.hartigehap.domain.weborder.WebOrder;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;

/**
 * Created by David-Paul on 11-2-14.
 */
public interface WebOrderRepository extends PagingAndSortingRepository<WebOrder, Long> {
}
