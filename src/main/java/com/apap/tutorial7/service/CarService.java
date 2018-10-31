package com.apap.tutorial7.service;

import java.util.List;

import com.apap.tutorial7.model.CarModel;

/**
 * @author DELL
 * CarService
 */
public interface CarService {
	CarModel addCar(CarModel car);
	void deleteCar(Long id);
	void updateCar(Long id, String amount, String brand, String price, String type);
	CarModel getCarById(long id);
	List<CarModel> viewAllCar();
}
