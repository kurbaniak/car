package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/"})
    public String message() {
        return "document/index";
    }


    @GetMapping({"/detail"})
    public String message2(){
        return "document/subIndex";
    }
}
