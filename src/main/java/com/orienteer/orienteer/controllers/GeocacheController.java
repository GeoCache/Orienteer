package com.orienteer.orienteer.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GeocacheController {

    @GetMapping("/home")
    @ResponseBody
    public String home() {
        return "Time to start your adventure";
    }


}
