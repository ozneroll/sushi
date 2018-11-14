/**
Project name: sushi
File name: City.java
Author: Lorenzo Lamberti
Date of creation: 1 nov. 2018
*/
package com.haagahelia.sushi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Entity
public class City {
	
	//city entity with all attributes
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long cityId;

	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
	private List<SushiRestaurant> sushiRestaurants;
	
	public City() {}
	
	public City(String name) {
		super();
		this.name = name;
	}
	
	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SushiRestaurant> getSushiRestaurants() {
		return sushiRestaurants;
	}

	public void setSushiRestaurants(List<SushiRestaurant> sushiRestaurants) {
		this.sushiRestaurants = sushiRestaurants;
	}

	@Override
	public String toString()
	{
		return this.name;
	}
}


