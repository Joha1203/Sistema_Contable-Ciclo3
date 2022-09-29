package com.example.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerHome {

    @GetMapping(path= "")
    public String inicio(){
        return "index";
    }

    @GetMapping(path= "/home")
    public String home(){
        return "index";
    }
}

