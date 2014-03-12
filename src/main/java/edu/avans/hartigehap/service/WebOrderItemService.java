package edu.avans.hartigehap.service;

import edu.avans.hartigehap.domain.AdditionalIngredient;
import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.domain.WebOrderItem;

/**
 * Created by Edwin Otten
 */
public interface WebOrderItemService {

    WebOrderItem getWebOrderItemById(long id);
    void deleteWebOrderItem(WebOrderItem webOrderItem);
    void addAditionalIngredient(WebOrderItem webOrderItem, AdditionalIngredient additionalIngredient);
    void save(WebOrderItem webOrderItem);
    void setMenuItem(WebOrderItem webOrderItem, MenuItem menuItem);
    
}
