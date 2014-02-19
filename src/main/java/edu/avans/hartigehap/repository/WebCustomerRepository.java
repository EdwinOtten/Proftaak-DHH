package edu.avans.hartigehap.repository;

import edu.avans.hartigehap.domain.weborder.WebCustomer;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by David-Paul on 15-2-14.
 */
public interface WebCustomerRepository extends PagingAndSortingRepository<WebCustomer, String> {
}
