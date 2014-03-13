package edu.avans.hartigehap.service.jpa;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.avans.hartigehap.domain.AdditionalIngredient;
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

	@Override
	public void addAditionalIngredient(WebOrderItem webOrderItem, AdditionalIngredient additionalIngredient) {
		webOrderItem.addIngredient(additionalIngredient);
		save(webOrderItem);
	}

	@Override
	public Collection<AdditionalIngredient> getAdditionalIngredients(WebOrderItem webOrderItem) {
		return webOrderItem.getAdditionalIngredients();
	}

	@Override
	public Boolean getFlagAdditionalIngredients(WebOrderItem webOrderItem) {
		if ( webOrderItem.getAdditionalIngredients().size() >= 1 ) {
			return true;
		}
		return false;
	}

	@Override
	public void removeAditionalIngredient(WebOrderItem webOrderItem, AdditionalIngredient additionalIngredient) {
		webOrderItem.removeIngredient(additionalIngredient);
		save(webOrderItem);
	}
	
}
