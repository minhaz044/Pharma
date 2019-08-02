package me.pharmacy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import me.pharmacy.model.MedicineCompany;

public interface MedicineCompanyRepository extends CrudRepository<MedicineCompany,Integer>{

    @Query("SELECT a FROM MedicineCompany a WHERE a.is_delete=false")
    public List<MedicineCompany> findAll();
}
