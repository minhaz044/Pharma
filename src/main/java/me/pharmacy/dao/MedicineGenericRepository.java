package me.pharmacy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import me.pharmacy.model.MedicineGeneric;

public interface MedicineGenericRepository  extends CrudRepository<MedicineGeneric,Integer>{

    @Query("SELECT a FROM MedicineGeneric a WHERE a.is_delete=false")
    public List<MedicineGeneric> findAll();
}
