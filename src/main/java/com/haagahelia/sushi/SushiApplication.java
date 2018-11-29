package com.haagahelia.sushi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.haagahelia.sushi.domain.City;
import com.haagahelia.sushi.domain.CityRepository;
import com.haagahelia.sushi.domain.SushiRestaurant;
import com.haagahelia.sushi.domain.SushiRestaurantRepository;
import com.haagahelia.sushi.domain.User;
import com.haagahelia.sushi.domain.UserRepository;


@SpringBootApplication
public class SushiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SushiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SushiApplication.class, args);
	}
	
	
}
