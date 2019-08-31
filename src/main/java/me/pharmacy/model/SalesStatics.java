/**
 * 
 */
package me.pharmacy.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Minhaz Uddin
 *
 * Aug 30, 2019
 */


public interface SalesStatics {
	 Double getTotalSalesValue();
	 Double getTotalComisionValue();
	 Double getTotalDueValue();
	 Date getDate();
	 
	

}

