/**
 * 
 */
package me.pharmacy.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import me.pharmacy.model.Buy;
import me.pharmacy.model.Customer;
import me.pharmacy.model.Expense;

/**
 * @author Minhaz Uddin
 *
 * Nov 16, 2019
 */
public interface ExpenseRepository  extends CrudRepository<Expense,Integer>{
    @Query(value="SELECT * FROM Expense a WHERE a.is_delete=0 AND a.created_at between :startDate AND :endDate",nativeQuery =true)
    public List<Expense> findAllByDate(@Param("startDate") Date startDate,@Param("endDate") Date endDate);

}

