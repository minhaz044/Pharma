 package me.pharmacy.dao;
 
 import java.util.List;
 
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.CrudRepository;
 
 import me.pharmacy.model.Customer;
 
 public interface CustomerRepository extends CrudRepository<Customer,Integer>{
 
     @Query("SELECT a FROM Customer a WHERE a.is_delete=false")
     public List<Customer> findAll();
 	
 
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
