/**
Project name: sushi
File name: CityRepository.java
Author: Lorenzo Lamberti
Date of creation: 1 nov. 2018
*/
package com.haagahelia.sushi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
	
	//CityRepository with a method
	
	List<City> findByName(String name);

}