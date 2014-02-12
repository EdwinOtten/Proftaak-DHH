package edu.avans.hartigehap.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * 
 * @author Edwin
 */
@Entity
@Table(name = "ADDITIONALINGREDIENTS")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter @Setter
@ToString(callSuper=true, includeFieldNames=true, of= {"name"})
@NoArgsConstructor
public class AdditionalIngredient extends DomainObject {
	
	@Autowired
	private BigDecimal price;
	@Autowired
	private String name;
	
	private static final long serialVersionUID = 1L;
	
}
