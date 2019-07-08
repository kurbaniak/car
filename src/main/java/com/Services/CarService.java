package com.Services;

import com.models.Car;
import com.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
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
                name("Mazda")
                .type("CX 5")
                .engine(2.5)
                .year("2019")
                .build());
    }
    private void mockCar2(){
        carRepository.save(Car.builder().
                name("Honda")
                .type("Accord")
                .engine(2.2)
                .year("2015")
                .build());
    }

    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    public Car updateCar(String carName, Car car){
        Optional<Car> foundedCar = carRepository.findCarByParam(carName);
        if(foundedCar.isPresent()){
            foundedCar.get().setName(car.getName());
            foundedCar.get().setType(car.getType());
            foundedCar.get().setEngine(car.getEngine());
            foundedCar.get().setYear(car.getYear());
            return carRepository.save(foundedCar.get());
        }

        return null;
    }

    public boolean deleteCarByName(String carName){
        if(carRepository.deleteCarByName(carName) == 1) {
            return true;
        }
        return false;
    }
}
