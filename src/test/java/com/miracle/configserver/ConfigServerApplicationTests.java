package com.miracle.configserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigServerApplicationTests {

	static {

		System.setProperty("spring.profiles.active", "native");
	}

	@Test
	public void contextLoads() {
	}

}
