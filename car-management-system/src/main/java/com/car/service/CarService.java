package com.car.service;

import com.car.model.Car;
import com.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
	
	
	 @Autowired
	    private CarRepository carRepository;

	    public Page<Car> getAllCars(Pageable pageable) {
	        return carRepository.findAll(pageable);
	    }

	    public Optional<Car> getCarById(Long id) {
	        return carRepository.findById(id);
	    }

	    public Car createCar(Car car) {
	        return carRepository.save(car);
	    }

	    public Car updateCar(Long id, Car carDetails) {
	        return carRepository.findById(id).map(car -> {
	            car.setName(carDetails.getName());
	            car.setModel(carDetails.getModel());
	            car.setYear(carDetails.getYear());
	            car.setPrice(carDetails.getPrice());
	            car.setColor(carDetails.getColor());
	            car.setFuelType(carDetails.getFuelType());
	            return carRepository.save(car);
	        }).orElseThrow(() -> new RuntimeException("Car not found"));
	    }

	    public void deleteCar(Long id) {
	        carRepository.deleteById(id);
	    }

}
