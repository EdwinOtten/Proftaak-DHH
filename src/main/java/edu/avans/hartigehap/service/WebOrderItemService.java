package edu.avans.hartigehap.service;

import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.domain.WebOrderItem;

/**
 * Created by Edwin Otten
 */
public interface WebOrderItemService {

	/**
	 * Returns a WebOrderItem by it's index.
     * @param id The ID of the WebOrderItem
     * @return The WebOrderItem
     */
    WebOrderItem getWebOrderItemById(long id);

	/**
	 * Deletes a WebOrderItem.
     * @param webOrderItem The WebOrderItem to be deleted
     */
    void deleteWebOrderItem(WebOrderItem webOrderItem);

	/**
	 * Saves a WebOrderItem.
     * @param webOrderItem The WebOrderItem to be saved
     */
    void save(WebOrderItem webOrderItem);

	/**
	 * Sets a MenuItem of the WebOrderItem.
     * @param webOrderItem The WebOrderItem on which the MenuItem needs to be set
     * @param menuItem The MenuItem to set
     */
    void setMenuItem(WebOrderItem webOrderItem, MenuItem menuItem);
    
}
