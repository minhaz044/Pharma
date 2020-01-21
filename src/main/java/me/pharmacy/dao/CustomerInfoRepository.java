package me.pharmacy.dao;

import me.pharmacy.model.CustomerInfo;
import me.pharmacy.model.Medicine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Minhaz on 1/21/2020.
 */
public interface CustomerInfoRepository  extends CrudRepository<CustomerInfo,Integer> {
    Optional<CustomerInfo> findByUserName(String username);
    @Query("SELECT a FROM CustomerInfo a WHERE a.is_delete=false")
    public List<CustomerInfo> findAll();
}
