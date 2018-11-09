/**
Project name: sushi
File name: SushiRestaurantController.java
Author: Lorenzo Lamberti
Date of creation: 1 nov. 2018
*/
package com.haagahelia.sushi.web;


import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Convert;

import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.haagahelia.sushi.domain.CityRepository;
import com.haagahelia.sushi.domain.SushiRestaurant;
import com.haagahelia.sushi.domain.SushiRestaurantRepository;


@Controller
public class SushiRestaurantController {
	
	@Autowired
	private SushiRestaurantRepository repository;
	
	@Autowired
	private CityRepository crepository;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
    //display list of restaurants
	@RequestMapping("/restaurantlist")
	public String restaurantlist(Model model) {
		model.addAttribute("restaurants", repository.findAll());
		return "restaurantlist";
	}
	
	//displays home page
	@RequestMapping("/")
	public String Home() {
		return "home";
	}
	
	//displays about page
	@RequestMapping("/about")
	public String About() {
		return "about";
	}
	
	//to add a new place
	@RequestMapping(value = "/addrestaurant")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addStudent(Model model){
		model.addAttribute("restaurant", new SushiRestaurant());
		model.addAttribute("cities", crepository.findAll());
		return "addrestaurant";
	}
	
	//to save a new restaurant in the repo
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(SushiRestaurant restaurant){
		repository.save(restaurant);
		return "redirect:restaurantlist";
	}
	
	//method to delete
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteRestaurant(@PathVariable("id") Long restaurantId, Model model) {
		repository.deleteById(restaurantId);
		return "redirect:../restaurantlist";
	}
	
	//edit
	@RequestMapping(value = "/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editRestaurant(@PathVariable("id") Long restaurantId, Model model) {
		model.addAttribute("restaurant", repository.findById(restaurantId));
		model.addAttribute("cities", crepository.findAll());
		return "editrestaurant";
	}
	
	//view the details
	@RequestMapping(value = "/view/{id}")
	public String viewRestaurant(@PathVariable("id") Long restaurantId, Model model) {
		
		
		repository.findById(restaurantId).ifPresent(o -> model.addAttribute("restaurant", o));
		
		//generate the html code for number of stars, for display purposes, here for overall rating
		double stars = repository.findById(restaurantId).get().getOverallRating();
		String str = "";
		while (stars >= 1) {
			str = str + "<span class='material-icons'>" + 
					"star" + 
					"</span>";
			stars = stars-1;
		}
		if (stars == 0.5)
		{
			str = str + "<span class='material-icons'>"+"star_half"+"</span>";
		}
		
		//same with selection
		double starsSelection = repository.findById(restaurantId).get().getSelection();
		String str2 = "";
		while (starsSelection >= 1) {
			str2 = str2 + "<span class='material-icons'>" + 
					"star" + 
					"</span>";
			starsSelection = starsSelection-1;
		}
		if (starsSelection == 0.5)
		{
			str2 = str2 + "<span class='material-icons'>"+"star_half"+"</span>";
		}
		
		//same for quality
		double starsQuality = repository.findById(restaurantId).get().getQuality();
		String str3 = "";
		while (starsQuality >= 1) {
			str3 = str3 + "<span class='material-icons'>" + 
					"star" + 
					"</span>";
			starsQuality = starsQuality-1;
		}
		if (starsQuality == 0.5)
		{
			str3 = str3 + "<span class='material-icons'>"+"star_half"+"</span>";
		}
		
		
		//give them to the view
		model.addAttribute("cities", crepository.findAll());
		model.addAttribute("stars", str);
		model.addAttribute("starsSelection", str2);
		model.addAttribute("starsQuality", str3);
		return "viewrestaurant";
	}
	
	
}
