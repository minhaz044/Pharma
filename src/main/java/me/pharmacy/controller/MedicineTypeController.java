package me.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.pharmacy.model.MedicineType;
import me.pharmacy.services.MedicineTypeService;
import me.pharmacy.services.MedicinegenericService;




@RestController
@RequestMapping("/type")
public class MedicineTypeController {
	@Autowired
	private MedicineTypeService medicineTypeService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	protected List<MedicineType> getMedicineType() {
		return medicineTypeService.getAllMedicineType();
	}
	
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	protected MedicineType addMedicineType(@RequestBody MedicineType type) {
		return medicineTypeService.saveMedicineType(type);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	protected MedicineType updateMedicineType(@RequestBody MedicineType type) {
		return medicineTypeService.saveMedicineType(type);
	}

	@RequestMapping(value = "/delete",method = RequestMethod.DELETE)
	protected void deleteMedicineType(@RequestBody MedicineType type) {
		medicineTypeService.deleteMedicineType(type);
	}
}
