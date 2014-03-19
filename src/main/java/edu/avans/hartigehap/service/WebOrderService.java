package edu.avans.hartigehap.service;

import edu.avans.hartigehap.domain.Ingredient;
import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.domain.Restaurant;
import edu.avans.hartigehap.domain.WebOrderItem;
import edu.avans.hartigehap.domain.weborder.WebCustomer;
import edu.avans.hartigehap.domain.weborder.WebOrder;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by David-Paul on 11-2-14.
 * Commented methods are for later use.
 */
public interface WebOrderService {
    WebOrder getWebOrderById(long sessionId);
    WebOrder save(WebOrder webOrder);
    void delete(WebOrder webOrder);
    long createNewWebOrder();
    void setWebCustomer(long sessionId, WebCustomer webCustomer);
    void finishOrder(long id);

//    WebOrder fetchWarmedUp(long sessionId);

    Iterable<WebOrder> findAll();
//    Page<WebOrder> findAllByPage(Pageable pageable);
    void addToWebOrder (WebOrder order, String name);	
}
