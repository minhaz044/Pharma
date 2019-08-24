package me.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.pharmacy.model.Medicine;
import me.pharmacy.services.MedicineService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private MedicineService medicineService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	protected List<Medicine> getMedicine() {
		 medicineService.getAllMedicine().forEach(s->System.out.println(s));
		return medicineService.getAllMedicine();
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	protected Medicine addMedicine(@RequestBody Medicine medicine) {
		return medicineService.saveMedicine(medicine);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	protected Medicine updateMedicine(@RequestBody Medicine medicine) {
		return medicineService.saveMedicine(medicine);
	}

	@RequestMapping(value = "/delete",method = RequestMethod.DELETE)
	protected void deleteMedicine(@RequestBody Medicine medicine) {
		 medicineService.deleteMedicine(medicine);
	}
}
