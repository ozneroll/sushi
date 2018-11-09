package com.haagahelia.sushi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.haagahelia.sushi.web.SushiRestaurantController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SushiApplicationTests {
	
	@Autowired
	private SushiRestaurantController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
