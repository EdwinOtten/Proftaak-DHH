package edu.avans.hartigehap.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.domain.WebOrderItem;
import edu.avans.hartigehap.repository.WebOrderItemRepository;
import edu.avans.hartigehap.service.WebOrderItemService;

@Service("webOrderItemService")
@Repository
@Transactional
public class WebOrderItemServiceImpl implements WebOrderItemService {

	@Autowired
	private WebOrderItemRepository webOrderItemRepo;
	
	/**
	 * {@inheritDoc}
     */
	@Override
	public WebOrderItem getWebOrderItemById(long id) {
		return webOrderItemRepo.findOne(id);
	}

	/**
	 * {@inheritDoc}
     */
	@Override
	public void deleteWebOrderItem(WebOrderItem webOrderItem) {
		webOrderItemRepo.delete(webOrderItem);
	}

	/**
	 * {@inheritDoc}
     */
	@Override
	public void save(WebOrderItem webOrderItem) {
		webOrderItemRepo.save(webOrderItem);
	}
	
	/**
	 * {@inheritDoc}
     */
	@Override
	public void setMenuItem(WebOrderItem webOrderItem, MenuItem menuItem) {
		webOrderItem.setMenuItem(menuItem);
		save(webOrderItem);
	}
	
}
