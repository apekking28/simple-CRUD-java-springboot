package com.car.carservice.service;

import com.car.carservice.entity.Car;
import com.car.carservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public Optional<Car> getDetailCar(Long id) {
        return carRepository.findById(id);
    }

    public Car updateCar(Long id, Car car) {
        var carDb = carRepository.findById(id);
        if(carDb.isPresent()){
            car.setId(id);
            return carRepository.save(car);
        }
        return null;
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
