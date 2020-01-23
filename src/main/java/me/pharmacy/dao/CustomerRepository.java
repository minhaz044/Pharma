 package me.pharmacy.dao;
 
 import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import me.pharmacy.model.Customer;
import me.pharmacy.model.SalesStatics;
 
 public interface CustomerRepository extends CrudRepository<Customer,Integer>{

     @Query("SELECT a FROM Customer a WHERE a.is_delete=false")
     public List<Customer> findAll();
     // , SUM(a.totalPrice*(a.comision/100)) ,SUM((a.totalPrice-(a.totalPrice*(a.comision/100))-a.payment)) 
     //@Query(value=" SELECT SUM(a.total_price-(a.total_price*(a.comision/100))) as totalSalesValue , SUM(a.total_price*(a.comision/100)) as totalComisionValue ,SUM((a.total_price-(a.total_price*(a.comision/100))-a.payment)) as totalDueValue ,:startDate as date FROM Customer a WHERE a.created_at BETWEEN :startDate AND :endDate AND  a.is_delete=0 ",nativeQuery =true)
     @Query(value=" SELECT SUM(a.total_price) totalSales ,SUM(a.payment) totalCollection,SUM(a.cash_Back_Amount) totalCashBack,SUM(a.total_price-(a.total_price*(a.comision/100))) as totalSalesValue , SUM(a.total_price*(a.comision/100)) as totalComisionValue ,SUM((a.total_price-(a.total_price*(a.comision/100))-a.payment)) as totalDueValue ,:startDate as date FROM Customer a WHERE a.created_at BETWEEN :startDate AND :endDate AND  a.is_delete=0 ",nativeQuery =true)
     public SalesStatics findAllSalesByDate(@Param("startDate") Date startDate,@Param("endDate") Date endDate);
     
     @Query(value="SELECT * FROM Customer a WHERE a.is_delete=0 AND a.created_at between :startDate AND :endDate",nativeQuery =true)
     public List<Customer> findAllByDate(@Param("startDate") Date startDate,@Param("endDate") Date endDate);



     @Query(value="SELECT * FROM Customer a WHERE a.is_delete=0 AND a.customer_info_id=:userId",nativeQuery =true)
     public List<Customer> findByUserId(@Param("userId") int userId);













     //@Query(" SELECT a FROM customer a WHERE a.createdAt BETWEEN :statDate AND :endDate AND  a.is_delete=false ")
     //public List<Customer> findAllByDate(@Param("statDate") Date statDate,@Param("endDate") Date endDate);
/*     
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
     
     /*
     
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
     
    
    */
    
     
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
