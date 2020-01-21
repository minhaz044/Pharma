package me.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.pharmacy.model.MedicineType;
import me.pharmacy.model.Person;
import me.pharmacy.services.MedicineTypeService;
import me.pharmacy.services.MedicinegenericService;
import me.pharmacy.services.PersonService;




@RestController
@RequestMapping("/salesPerson")
public class SalesPersonController {
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	protected List<Person> getSalesPerson() {
		return personService.getAllPerson();
	}

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	protected Person addSalesPerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	protected Person updateSalesPersone(@RequestBody Person person) {
		return personService.savePerson(person);
	}

	@RequestMapping(value = "/delete",method = RequestMethod.DELETE)
	protected void deleteSalesPerson(@RequestBody Person person) {
		personService.deletePerson(person);
	}
}
