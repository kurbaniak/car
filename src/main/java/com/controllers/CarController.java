package com.controllers;

import com.Services.CarService;

import com.models.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/v1/car")
    public ResponseEntity<Car> getCarByName(@RequestParam(value = "carName") String carName){
        return new ResponseEntity<>(carService.getCarName(carName), HttpStatus.OK);
    }

    @GetMapping("/api/v1")
    public String message(){
            return "Select right endpoint";
        }

    @GetMapping(value = "/api/v1/cars", produces = "application/json")
    public List<Car> getCars() {
        return carService.getCars();
    }
}

