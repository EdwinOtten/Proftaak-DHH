package edu.avans.hartigehap.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * 
 * @author Edwin
 */
@Entity
@Table(name = "WEBORDERITEMS")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter @Setter
@NoArgsConstructor
public class WebOrderItem extends DomainObject {
	
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
			description += " met: ";
			while (itr.hasNext()) {
				description += itr.next().getName() + ", ";
			}
		}
		return description;
	}
	
	public String getName() {
		return menuItem.getId();
	}
	
	
}
