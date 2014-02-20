package edu.avans.hartigehap.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;

import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.domain.WebOrderItem;
import edu.avans.hartigehap.repository.WebOrderItemRepository;
import edu.avans.hartigehap.service.WebOrderItemService;

public class WebOrderItemServiceImpl implements WebOrderItemService {

	@Autowired
	private WebOrderItemRepository webOrderItemRepo;
	
	@Override
	public WebOrderItem getWebOrderItemById(long id) {
		return webOrderItemRepo.findOne(id);
	}

	@Override
	public void deleteWebOrderItem(WebOrderItem webOrderItem) {
		webOrderItemRepo.delete(webOrderItem);
	}

	@Override
	public void save(WebOrderItem webOrderItem) {
		webOrderItemRepo.save(webOrderItem);
	}

	@Override
	public void setMenuItem(WebOrderItem webOrderItem, MenuItem menuItem) {
		webOrderItem.setMenuItem(menuItem);
		save(webOrderItem);
	}
	
}