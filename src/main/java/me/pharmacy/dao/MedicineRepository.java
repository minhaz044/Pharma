package me.pharmacy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import me.pharmacy.model.Medicine;

public interface MedicineRepository  extends CrudRepository<Medicine,Integer> {

    @Query("SELECT a FROM Medicine a WHERE a.delete=false")
    public List<Medicine> findAll();
}
