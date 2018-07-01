package com.orienteer.orienteer.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GeocacheController {

@GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model view) {
        view.addAttribute("name", name);
        return "hello";
    }


}
