package edu.avans.hartigehap.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.avans.hartigehap.domain.AdditionalIngredient;
import edu.avans.hartigehap.domain.WebOrderItem;
import edu.avans.hartigehap.repository.AdditionalIngredientRepository;
import edu.avans.hartigehap.service.AdditionalIngredientService;

@Service("additionalIngredientService")
@Repository
@Transactional
public class AdditionalIngredientServiceImpl implements AdditionalIngredientService {

	@Autowired
	private AdditionalIngredientRepository additionalIngredientRepo;
	
	@Override
	public AdditionalIngredient getAdditionalIngredientById(long id) {
		return additionalIngredientRepo.findOne(id);
	}

	@Override
	public Iterable<AdditionalIngredient> getAllAdditionalIngredients() {
		return additionalIngredientRepo.findAll();
	}

	
}
