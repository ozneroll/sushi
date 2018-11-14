/**
Project name: sushi
File name: SushiRestaurant.java
Author: Lorenzo Lamberti
Date of creation: 1 nov. 2018
*/

package com.haagahelia.sushi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@Entity
public class SushiRestaurant {
	
	//SushiRestaurant class with all attributes
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	private String name;
	
	private String description;
	
	private String latitude;
	private String longitude;
	private double overallRating;
	private double price;
	private double selection;
	private double quality;
	private String extraFeatures;
	
	//many to one join
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "city")
	@JsonProperty
    private City city;

	public SushiRestaurant() {};
	
	public SushiRestaurant(String name, String description, String latitude, String longitude, double overallRating, double price, double selection, double quality, String extraFeatures, City city)
	{
		super();
		this.name = name;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.overallRating = overallRating;
		this.price = price;
		this.selection = selection;
		this.quality = quality;
		this.extraFeatures = extraFeatures;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public double getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(double overallRating) {
		this.overallRating = overallRating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSelection() {
		return selection;
	}

	public void setSelection(double selection) {
		this.selection = selection;
	}

	public double getQuality() {
		return quality;
	}

	public void setQuality(double quality) {
		this.quality = quality;
	}

	public String getExtraFeatures() {
		return extraFeatures;
	}

	public void setExtraFeatures(String extraFeatures) {
		this.extraFeatures = extraFeatures;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	
	
}