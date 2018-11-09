/**
Project name: sushi
File name: SushiRestaurantRepositoryTest.java
Author: Lorenzo Lamberti
Date of creation: 9 nov. 2018
*/
package com.haagahelia.sushi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.haagahelia.sushi.domain.City;
import com.haagahelia.sushi.domain.SushiRestaurant;
import com.haagahelia.sushi.domain.SushiRestaurantRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class SushiRestaurantRepositoryTest {

    @Autowired
    private SushiRestaurantRepository repository;

    @Test
    public void findByTitleShouldReturnRestaurant() {
        List<SushiRestaurant> sushi = repository.findByName("Haru");
        
        assertThat(sushi).hasSize(1);
        assertThat(sushi.get(0).getCity()).isEqualTo("Helsinki");
    }
    
    @Test
    public void createNewRestaurant() {
    	SushiRestaurant sushi = new SushiRestaurant("Makuja", "Weird place", "11", "41", 3, 12.90, 3, 3, "Drink fountain", new City("New York"));
    	repository.save(sushi);
    	assertThat(sushi.getId()).isNotNull();
    }    

}