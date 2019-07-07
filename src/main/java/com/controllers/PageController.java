package com.controllers;

import com.Services.CarService;
import com.models.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PageController {

    CarService carService;

    public PageController(CarService carService) {
        this.carService = carService;
    }

//    @GetMapping({"/"})
//    public String message() {
//        return "document/index";
//    }


    @GetMapping({"/detail"})
    public String detail(Model model){
        List<Car> cars = carService.getCars();
        model.addAttribute("cars", cars);
        return "document/subIndex";
    }

    @GetMapping({"/", "/api/v1", "/api"})
    public String index() {
        return "document/index";
    }

    @GetMapping("/swagger")
    public String swagger() {
        return "swagger-ui";
    }


}
