package me.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.pharmacy.model.Medicine;
import me.pharmacy.model.MedicineCompany;
import me.pharmacy.services.MedicineCompanyService;
import me.pharmacy.services.MedicineService;



@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private MedicineCompanyService medicineCompanyService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	protected List<MedicineCompany> getMedicineCompany() {
		System.out.println("**************Function Is called***********");
		return medicineCompanyService.getAllMedicineCompany();
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	protected MedicineCompany addMedicineCompany(@RequestBody MedicineCompany medicineCompany) {
		return medicineCompanyService.saveMedicineCompany(medicineCompany);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	protected MedicineCompany updateMedicineCompany(@RequestBody MedicineCompany medicineCompany) {
		return medicineCompanyService.saveMedicineCompany(medicineCompany);
	}

	@RequestMapping(value = "/delete",method = RequestMethod.DELETE)
	protected void deleteMedicineCompany(@RequestBody MedicineCompany medicineCompany) {
		medicineCompanyService.deleteMedicineCompany(medicineCompany);
	}
}