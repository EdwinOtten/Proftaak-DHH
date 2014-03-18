package edu.avans.hartigehap.domain.weborder;

import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.domain.WebOrderItem;
import edu.avans.hartigehap.service.MenuItemService;
import edu.avans.hartigehap.service.WebOrderItemService;
import edu.avans.hartigehap.service.WebOrderService;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by David-Paul on 7-3-14.
 */
public class WebOrderTest {

    @Resource
    private WebOrderService webOrderService;
    @Resource
    private WebOrderItemService webOrderItemService;
    @Resource
    private MenuItemService menuItemService;

    private long id;
    private WebOrder webOrder;

    /**
     * Initializes the needed weborder, weborderitems and webcustomer
     */
    private void setUp() {
        id = webOrderService.createNewWebOrder();
        webOrder = webOrderService.getWebOrderById(id);

        MenuItem firstPizza = menuItemService.findByFoodCategoriesId(MenuItemService.PIZZA).get(0);
        WebOrderItem webOrderItem = new WebOrderItem();
        webOrderItem.setWebOrder(webOrder);
        webOrderItem.setMenuItem(firstPizza);
        WebCustomer webCustomer = new WebCustomer();
        webCustomer.setCity("TestCity");
        webCustomer.setAddress("TestAddress");
        webCustomer.setName("TestName");
        webOrder.setCustomer(webCustomer);
        
        webOrderService.save(webOrder);
        webOrderItemService.save(webOrderItem);
    }

    @Test
    public void testInitialization() {
        setUp();

        WebOrder retrievedWebOrder = webOrderService.getWebOrderById(id);
        org.junit.Assert.assertNotNull("The WebOrder is null after initializing and retrieving.", retrievedWebOrder);
        org.junit.Assert.assertNotNull("The WebCustomer is null after initializing and retrieving.", retrievedWebOrder.getCustomer());
        org.junit.Assert.assertNotNull("The WebOrderItems are null after initializing and retrieving.", retrievedWebOrder.getWebOrderItems());
    }

    /**
     * Tests that a new WebOrder can be created without any Exception is been thrown.
     * @throws Exception
     */
    @Test
    public void testNewWebOrder() throws Exception {
        long id = webOrderService.createNewWebOrder();
    }

    @Test
    public void testFinishWebOrder() {
        setUp();
        webOrder.finishWebOrder();
        
        WebOrder retrievedWebOrder = webOrderService.getWebOrderById(id);
        org.junit.Assert.assertEquals(retrievedWebOrder.getWebOrderState(), webOrder.getWebOrderState());
    }
}
