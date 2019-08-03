 package me.pharmacy.dao;
 
 import java.util.Date;
import java.util.List;
 
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import me.pharmacy.model.Customer;
 
 public interface CustomerRepository extends CrudRepository<Customer,Integer>{
 
     @Query("SELECT a FROM Customer a WHERE a.is_delete=false")
     public List<Customer> findAll();
     
     @Query("SELECT a FROM Customer a WHERE a.createdAt BETWEEN :statDate AND :endDate AND a. a.is_delete=false ")
     public List<Customer> findAllSalesByDate(@Param("statDate") Date statDate,@Param("endDate") Date endDate);
     
     @Query("SELECT a FROM Customer a WHERE a.createdAt BETWEEN :statDate AND :endDate AND ((a.total_price-((a.comision*a.totalPrice)/100))-a.due)>0 AND a. a.is_delete=false ")
     public List<Customer> findAllDueByDate(@Param("statDate") Date statDate,@Param("endDate") Date endDate);
     
     
     @Query("SELECT a FROM Customer a WHERE a.createdAt BETWEEN :statDate AND :endDate AND a.comision>0 AND a. a.is_delete=false ")
     public List<Customer> findAllCommissionByDate(@Param("statDate") Date statDate,@Param("endDate") Date endDate);
     
     @Query("SELECT a FROM Customer a WHERE a.createdAt BETWEEN :statDate AND :endDate AND a.due>0 AND a. a.is_delete=false ")
     public List<Customer> findAllCashPaidByDate(@Param("statDate") Date statDate,@Param("endDate") Date endDate);
     
     /*
     @Query("SELECT a FROM Customer a WHERE a.createdAt BETWEEN :statDate AND :endDate AND a.totalPrice>0 AND a. a.is_delete=false ")
     public List<Customer> findAllSalesByDate(@Param("statDate") Date statDate,@Param("endDate") Date endDate);
     
     
     */
     
     
     
     @Query("SELECT SUM((a.total_price-((a.comision*a.totalPrice)/100))) FROM Customer a WHERE a.createdAt BETWEEN :statDate AND :endDate AND a.is_delete=false ")
     Integer findTotalEarnByDate(@Param("statDate") Date statDate,@Param("endDate") Date endDate);
 	
     @Query("SELECT SUM(((a.comision*a.totalPrice)/100)) FROM Customer a WHERE a.createdAt BETWEEN :statDate AND :endDate AND a.is_delete=false ")
     Integer findTotalComisionByDate(@Param("statDate") Date statDate,@Param("endDate") Date endDate);
     
     @Query("SELECT SUM(a.totalPrice) FROM Customer a WHERE a.createdAt BETWEEN :statDate AND :endDate AND a.is_delete=false ")
     Integer findTotalSalesByDate(@Param("statDate") Date statDate,@Param("endDate") Date endDate);
     
    @Query("SELECT SUM((a.due) FROM Customer a WHERE a.createdAt BETWEEN :statDate AND :endDate AND a.is_delete=false ")
    Integer findTotalCashPaidByDate(@Param("statDate") Date statDate,@Param("endDate") Date endDate);
 	
    @Query("SELECT SUM((a.total_price-((a.comision*a.totalPrice)/100))-a.due) FROM Customer a WHERE a.createdAt BETWEEN :statDate AND :endDate AND a.is_delete=false ")
    Integer findTotalDueByDate(@Param("statDate") Date statDate,@Param("endDate") Date endDate);
     
    
    
    
     
     /*
 	 * LIKE CONCAT('%',:username,'%')
 	 * 
 	 * @Query("SELECT a FROM Customer a WHERE a.customerName=:customerName") public
 	 * List<Assign> findBybatchId(@Param("customerName") String customerName);
 	 * 
 	 * 
 	 * 
 	 * @Query("SELECT a FROM Assign a WHERE a.teacher_id=:teacher_id") public
 	 * List<Assign> findbyTeacherId(@Param("teacher_id") int teacher_id);
 	 */
 
 }
