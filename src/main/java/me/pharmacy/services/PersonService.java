package me.pharmacy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.pharmacy.dao.MedicineTypeRepository;
import me.pharmacy.dao.PresonRepository;
import me.pharmacy.model.MedicineType;
import me.pharmacy.model.Person;

@Service
public class PersonService {
	
	@Autowired
	private PresonRepository presonRepository;
	
	public Person savePerson(Person person ) {
		return presonRepository.save(person);
	}
	public void deletePerson(Person person ) {
		presonRepository.delete(person);
	}
	
	public List<Person> getAllPerson() {
		return (List<Person>) presonRepository.findAll();
	}


}
