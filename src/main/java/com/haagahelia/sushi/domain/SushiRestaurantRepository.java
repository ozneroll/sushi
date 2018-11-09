/**
Project name: sushi
File name: SushiRestaurantRepository.java
Author: Lorenzo Lamberti
Date of creation: 1 nov. 2018
*/
package com.haagahelia.sushi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SushiRestaurantRepository extends CrudRepository<SushiRestaurant, Long> {

	//sushi restaurant repo only method
	
	List<SushiRestaurant> findByName(String name);	

}
