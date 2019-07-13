package me.pharmacy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.pharmacy.dao.MedicineGenericRepository;

import me.pharmacy.model.MedicineGeneric;
@Service
public class MedicinegenericService {
	@Autowired
	private MedicineGenericRepository medicineGenericRepository;
	
	public MedicineGeneric saveMedicineGeneric(MedicineGeneric generic ) {
		return medicineGenericRepository.save(generic);
	}
	
	public void deleteMedicineGeneric(MedicineGeneric generic ) {
		medicineGenericRepository.delete(generic);
	}
	
	public List<MedicineGeneric> getAllMedicineGeneric() {
		return medicineGenericRepository.findAll();
	}
}
