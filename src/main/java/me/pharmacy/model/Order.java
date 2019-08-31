/**
 * 
 */
package me.pharmacy.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Minhaz Uddin
 *
 * Aug 30, 2019
 */


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private List<Sales>orders;
	private Customer customer;
}
