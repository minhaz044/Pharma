package me.pharmacy.dao;

import me.pharmacy.model.Customer;
import me.pharmacy.model.DuePayHistry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Minhaz on 1/26/2020.
 */
@Repository
public interface DuePayHistryRepository extends CrudRepository<DuePayHistry,Integer> {


    @Query(value="SELECT * FROM due_pay_histry a WHERE a.is_delete=0 AND a.customer_info_id=:customerId",nativeQuery =true)
    public List<DuePayHistry> findByCustomerId(@Param("customerId") int customerId);
}
