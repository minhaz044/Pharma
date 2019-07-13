package me.pharmacy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.pharmacy.dao.MedicineRepository;
import me.pharmacy.model.Medicine;
@Service
public class MedicineService {
	@Autowired
	private MedicineRepository medicineRepo;
	
	public Medicine saveMedicine(Medicine medicine ) {
		return medicineRepo.save(medicine);
	}
	
	public void deleteMedicine(Medicine medicine ) {
		medicineRepo.delete(medicine);
	}
	
	public List<Medicine> getAllMedicine() {
		return medicineRepo.findAll();
	}

}
