package com.hissong.springokta.Controllers;

import com.hissong.springokta.Data.CarRepo;
import com.hissong.springokta.Models.Car;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CoolCarController {
	private CarRepo carRepo;

	public CoolCarController(CarRepo carRepo){
		this.carRepo = carRepo;
	}

	@GetMapping("/cool-cars")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Car> coolCars() {
		return carRepo.findAll().stream()
				.filter(this::isCool)
				.collect(Collectors.toList());
	}

	private boolean isCool(Car car) {
		return !car.getName().equals("AMC Gremlin") &&
				!car.getName().equals("Triumph Stag") &&
				!car.getName().equals("Ford Pinto") &&
				!car.getName().equals("Yugo GV");
	}
}
