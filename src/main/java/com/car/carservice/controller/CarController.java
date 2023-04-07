package com.car.carservice.controller;

import com.car.carservice.entity.Car;
import com.car.carservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public List<Car> getAllCar() {
        return carService.getAllCar();
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @GetMapping("{id}")
    public Optional<Car> getDetailCar(@PathVariable Long id){
        return carService.getDetailCar(id);
    }

    @PutMapping("{id}")
    public Car updateCar(@PathVariable("id") Long id,@RequestBody Car car){
        return carService.updateCar(id,car);
    }

    @DeleteMapping("{id}")
    public String deleteCar(@PathVariable("id")Long id){
        carService.deleteCar(id);
        return "Succsesfully delete the car";
    }
}
