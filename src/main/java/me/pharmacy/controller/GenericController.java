package me.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.pharmacy.model.MedicineGeneric;
import me.pharmacy.services.MedicinegenericService;


@RestController
@RequestMapping("/generic")
public class GenericController {
	@Autowired
	private MedicinegenericService medicinegenericService;
	
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	protected List<MedicineGeneric> getMedicineGeneric() {
		return medicinegenericService.getAllMedicineGeneric();
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	protected MedicineGeneric addMedicineGeneric(@RequestBody MedicineGeneric generic) {
		return medicinegenericService.saveMedicineGeneric(generic);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	protected MedicineGeneric updateMedicineGeneric(@RequestBody MedicineGeneric generic) {
		return medicinegenericService.saveMedicineGeneric(generic);
	}

	@RequestMapping(value = "/delete",method = RequestMethod.DELETE)
	protected void deleteMedicineGeneric(@RequestBody MedicineGeneric generic) {
		medicinegenericService.deleteMedicineGeneric(generic);
	}
}