package me.pharmacy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import me.pharmacy.model.MedicineType;

public interface MedicineTypeRepository  extends CrudRepository<MedicineType,Integer>{

    @Query("SELECT a FROM MedicineType a WHERE a.is_delete=false")
    public List<MedicineType> findAll();
}
