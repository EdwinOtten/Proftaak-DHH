package edu.avans.hartigehap.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.*;

import edu.avans.hartigehap.domain.weborder.WebOrder;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * 
 * @author Edwin
 */
@Entity
@Table(name = "WEBORDERITEM")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@NoArgsConstructor
public class WebOrderItem extends DomainObject {
	@ManyToOne
    @JoinColumn(name="weborder_id")
    private WebOrder webOrder;

	private MenuItem menuItem;
	private ArrayList<AdditionalIngredient> AdditionalIngredients;
	
	private static final long serialVersionUID = 1L;
	
	public BigDecimal getPrice() {
		BigDecimal totalPrice = new BigDecimal(menuItem.getPrice());
		
		if ( AdditionalIngredients.size() > 0) {
			Iterator<AdditionalIngredient> itr = AdditionalIngredients.iterator();
			while (itr.hasNext()) {
				totalPrice = totalPrice.add(itr.next().getPrice());
			}
		}
		return totalPrice;
	}
	
	public String getDescription() {
		String description = "Een " + menuItem.getId();
		if ( AdditionalIngredients.size() > 0) {
			Iterator<AdditionalIngredient> itr = AdditionalIngredients.iterator();
			description += " met:";
			while (itr.hasNext()) {
				description += " " + itr.next().getName() + ",";
			}
			// remove last comma
			description = description.substring(0, description.length() - 1);
		}
		return description;
	}
	
	public String getName() {
		return menuItem.getId();
	}
	
	public void addIngredient(AdditionalIngredient ingredient) {
		this.AdditionalIngredients.add(ingredient);
	}
	
	public void removeIngredient(AdditionalIngredient ingredient) {
		this.AdditionalIngredients.remove(ingredient);
	}
	
	public void removeIngredientAtIndex(int index) {
		this.AdditionalIngredients.remove(index);
	}
	
	
}
