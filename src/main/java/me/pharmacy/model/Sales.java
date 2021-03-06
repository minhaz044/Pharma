/**
 * 
 */
package me.pharmacy.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Minhaz Uddin
 *
 * Aug 30, 2019
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sales {
	private Medicine product;
	private Double quantity;

}
