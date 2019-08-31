package me.pharmacy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import me.pharmacy.model.SalesProduct;

public interface SalesProductRepository  extends CrudRepository<SalesProduct,Integer> {

    @Query("SELECT a FROM SalesProduct a WHERE a.is_delete=false")
    public List<SalesProduct> findAll();
    
  
}
