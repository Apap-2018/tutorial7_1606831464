package com.apap.tutorial7.controller;

import com.apap.tutorial7.model.*;
import com.apap.tutorial7.service.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 * @author DELL
 * CarController
 */

@Controller
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarService carService;
	
	@Autowired
	private DealerService dealerService;
	
	@PostMapping("/add")
	private CarModel addCarSubmit(@RequestBody CarModel car) {
		return carService.addCar(car);
	}
	@GetMapping(value = "/{carId}")
	private CarModel viewCar(@PathVariable ("carId") long carId, Model model) {
		return carService.getCarById(carId);
	}
	@DeleteMapping(value = "/{carId}")
	private String deleteCar(@PathVariable("carId") long id, Model model) {
		carService.deleteCar(id);
		return "Car has been deleted";
	}
	@PutMapping(value = "/{carId}")
	private String updateCarSubmit(
			@PathVariable (value = "carId") long carId,
			@RequestParam("brand") String brand,
			@RequestParam("type") String type,
			@RequestParam("price") String price,
			@RequestParam("amount") String amount,
			@RequestParam("dealerId") long dealerId) {
		CarModel car = (CarModel) carService.getCarById(carId);
		if(car.equals(null)) {
			return "Couldn't find your car";
			}
		car.setAmount(amount);
		car.setBrand(brand);
		car.setPrice(price);
		car.setType(type);
		carService.updateCar(carId, amount, brand, price, type);
		return " car update success";
		}
	
	@GetMapping()
	private List<CarModel> viewAllCar(Model model) {
		return carService.viewAllCar();
	}
}
