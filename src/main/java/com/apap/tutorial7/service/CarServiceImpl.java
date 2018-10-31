package com.apap.tutorial7.service;

import java.util.List;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.repository.CarDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author DELL
 * CarServiceImpl
 */

@Service
@Transactional
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDb carDb;
	
	@Override
	public CarModel addCar(CarModel car) {
		carDb.save(car);
		return car;
		
	}

	@Override
	public void deleteCar(Long id) {
		carDb.deleteById(id);
		
	}

	@Override
	public void updateCar(Long id, String amount, String brand, String price, String type) {
		carDb.getOne(id).setAmount(amount);
		carDb.getOne(id).setBrand(brand);
		carDb.getOne(id).setPrice(price);
		carDb.getOne(id).setType(type);
	}

	@Override
	public CarModel getCarById(long id) {
		return carDb.findById(id).get();
	}

	@Override
	public List<CarModel> viewAllCar() {
		return carDb.findAll();
	}
	

}
