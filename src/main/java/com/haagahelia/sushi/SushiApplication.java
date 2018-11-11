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
	
	@Bean
	public CommandLineRunner demo(SushiRestaurantRepository srepository, CityRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			//creating users
			//User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "killian@gmail.com", "USER");
			//User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "lorenzo@gmail.com", "ADMIN");
			
			//save them in the UserRepository
			//urepository.save(user1);
			//urepository.save(user2);
			
			//save some cities
			//crepository.save(new City("Helsinki"));
			//crepository.save(new City("Sion"));
			
			//save the restaurants
			//srepository.save(new SushiRestaurant("Haru", "Popular chain of sushi restaurants in the finnish capital", "11", "41", 5, 11.90, 4, 4.5, "Drink fountain", crepository.findByName("Helsinki").get(0)));
			//srepository.save(new SushiRestaurant("Itsudemo", "Sushi buffet near the station of Helsinki", "12", "42", 4.5, 13, 4, 4.5, "Drink fountain, hot food, desserts, tea", crepository.findByName("Helsinki").get(0)));
			

		};
	}
}
