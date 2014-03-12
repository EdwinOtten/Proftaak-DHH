package edu.avans.hartigehap.service;

import edu.avans.hartigehap.domain.AdditionalIngredient;

/**
 * Created by Edwin Otten
 */
public interface AdditionalIngredientService {

	AdditionalIngredient getAdditionalIngredientById(long id);

	Iterable<AdditionalIngredient> getAllAdditionalIngredients();
    
}
