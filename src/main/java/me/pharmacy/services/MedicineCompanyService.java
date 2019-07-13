package me.pharmacy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.pharmacy.dao.MedicineCompanyRepository;
import me.pharmacy.model.MedicineCompany;
@Service
public class MedicineCompanyService {
	
	@Autowired
	private MedicineCompanyRepository medicineCompanyRepository;
	
	public MedicineCompany saveMedicineCompany(MedicineCompany medicineCompany ) {
		return medicineCompanyRepository.save(medicineCompany);
	}
	
	public void deleteMedicineCompany(MedicineCompany medicineCompany ) {
		medicineCompanyRepository.delete(medicineCompany);
	}
	
	public List<MedicineCompany> getAllMedicineCompany() {
		return medicineCompanyRepository.findAll();
	}

}
