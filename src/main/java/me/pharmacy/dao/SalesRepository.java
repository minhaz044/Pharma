package me.pharmacy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import me.pharmacy.model.Sales;

public interface SalesRepository  extends CrudRepository<Sales,Integer> {

    @Query("SELECT a FROM Sales a WHERE a.is_delete=false")
    public List<Sales> findAll();
}
