package me.pharmacy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.pharmacy.dao.MedicineTypeRepository;
import me.pharmacy.model.MedicineType;
@Service
public class MedicineTypeService {
	@Autowired
	private MedicineTypeRepository medicineTypeRepository;
	
	public MedicineType saveMedicineType(MedicineType type ) {
		return medicineTypeRepository.save(type);
	}
	public void deleteMedicineType(MedicineType type ) {
		medicineTypeRepository.delete(type);
	}
	
	public List<MedicineType> getAllMedicineType() {
		return medicineTypeRepository.findAll();
	}

}
