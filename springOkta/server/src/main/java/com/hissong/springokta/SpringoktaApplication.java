package com.hissong.springokta;

import com.hissong.springokta.Data.CarRepo;
import com.hissong.springokta.Models.Car;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import java.util.Collections;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringoktaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringoktaApplication.class, args);
	}


	@Bean
	ApplicationRunner init(CarRepo carRepo) {
		return args -> {
			Stream.of("Ferrari","Jaguar","Porsche","Lamborghini","Bugatti",
					"AMC Gremlin", "Triumph Stag", "Ford Pinto","Yugo GV").forEach(name ->{
				Car car = new Car();
				car.setName(name);
				carRepo.save(car);
			});
			carRepo.findAll().forEach(System.out::println);
		};
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		configuration.setAllowedMethods(Collections.singletonList("*"));
		configuration.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**",configuration);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
