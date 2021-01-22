package com.koreait.quiz2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:app-context2.xml")
@Configuration
public class AppContext2 {

	@Bean
	public Engine engine1() {
		return new Engine("디젤", 1990, 250, 12.5);
	}
	
	@Bean
	public Car car1() {
		return new Car("520d", engine1());
	}
}
