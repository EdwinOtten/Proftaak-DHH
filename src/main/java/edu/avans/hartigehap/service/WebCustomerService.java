package edu.avans.hartigehap.service;

import edu.avans.hartigehap.domain.weborder.WebCustomer;
import edu.avans.hartigehap.domain.weborder.WebOrder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by David-Paul on 15-2-14.
 */

public interface WebCustomerService {
    WebCustomer getCustomerBySessionId(long sessionId);
    WebCustomer save(long sessionId, WebCustomer webCustomer);
    void delete(WebCustomer webCustomer);
}
