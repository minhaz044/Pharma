package me.pharmacy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import me.pharmacy.model.Person;

public interface PresonRepository  extends CrudRepository<Person,Integer> {

	/*
	 * @Query("SELECT a FROM Person a WHERE a.delete=false") public List<Person>
	 * findAll();
	 */
}
