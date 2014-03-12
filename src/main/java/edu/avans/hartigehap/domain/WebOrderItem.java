package edu.avans.hartigehap.domain;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import edu.avans.hartigehap.domain.weborder.WebOrder;
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
@Table(name = "WEBORDERITEM")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@NoArgsConstructor
@Getter
@Setter
public class WebOrderItem extends DomainObject {
	@ManyToOne
    @JoinColumn(name="weborder_id")
    private WebOrder webOrder;

	@OneToOne
	@Getter
	@Setter
	private MenuItem menuItem;
	
    @ManyToMany
	private Collection<AdditionalIngredient> additionalIngredients;
	
	private static final long serialVersionUID = 1L;
	
	public BigDecimal getPrice() {
		BigDecimal totalPrice = new BigDecimal(menuItem.getPrice());
		
		if ( additionalIngredients != null && additionalIngredients.size() > 0) {
			Iterator<AdditionalIngredient> itr = additionalIngredients.iterator();
			while (itr.hasNext()) {
				totalPrice = totalPrice.add(itr.next().getPrice());
			}
		}
		return totalPrice;
	}
	
	public String getPriceString() {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		return nf.format(getPrice());
	}
	
	public String getDescription() {
		String description = "Een " + menuItem.getId();
		
		if ( additionalIngredients != null && additionalIngredients.size() > 0) {
			Iterator<AdditionalIngredient> itr = additionalIngredients.iterator();
			description += " met:<ul>";
			while (itr.hasNext()) {
				description += "<li>" + itr.next().getName() + "</li>";
			}
			// remove last comma
			description += "</ul>";
		}
		return description;
	}
	
	public String getName() {
		return menuItem.getId();
	}
	
	public void addIngredient(AdditionalIngredient ingredient) {
		this.additionalIngredients.add(ingredient);
	}
	
	public void removeIngredient(AdditionalIngredient ingredient) {
		this.additionalIngredients.remove(ingredient);
	}
	
	public void removeIngredientAtIndex(int index) {
		this.additionalIngredients.remove(index);
	}
	
	
}
