package com.controllers;

import com.Services.CarService;

import com.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class CarController {

    @Autowired
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/v1/car")
    public ResponseEntity<Car> getCarByName(@RequestParam(value = "carName") String carName) {
        return new ResponseEntity<>(carService.getCarName(carName), HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/cars", produces = "application/json")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @PostMapping("/api/v1/newCar")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return ResponseEntity.ok()
                .header("car_header", "Car_Header_1")
                .body(carService.saveCar(car));
    }

@PutMapping("/api/v1/updateCar")
    public ResponseEntity<Car> updateCar(@RequestParam(value = "carName") String carName,
                                         @RequestBody Car car){
        Car result = carService.updateCar(carName, car);
        if(result != null){
            return ResponseEntity.ok()
                    .header("car_header", "Car_Header_1")
                    .body(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@DeleteMapping("/api/v1/deleteCar")
    public ResponseEntity<?> deleteCarByName(@RequestParam(value = "carName") String carName){
        if(carService.deleteCarByName(carName)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}

