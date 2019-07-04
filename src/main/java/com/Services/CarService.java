package com.Services;

import com.models.Car;
import com.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
        mockCar();
        mockCar2();
    }

    public Car getCarName(String carName){
        return carRepository.findCarByParam(carName).get();
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    private void mockCar(){
        carRepository.save(Car.builder().
                name("Car1")
                .type("Type1")
                .engine(1234L)
                .year(9876L)
                .build());
    }
    private void mockCar2(){
        carRepository.save(Car.builder().
                name("Car2")
                .type("Type1")
                .engine(1234L)
                .year(9876L)
                .build());
    }
}
