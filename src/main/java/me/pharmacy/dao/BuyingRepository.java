/**
 * 
 */
package me.pharmacy.dao;

import org.springframework.data.repository.CrudRepository;

import me.pharmacy.model.Buy;
import me.pharmacy.model.Customer;

/**
 * @author Minhaz Uddin
 *
 * Sep 6, 2019
 */
public interface BuyingRepository  extends CrudRepository<Buy,Integer>{

}
