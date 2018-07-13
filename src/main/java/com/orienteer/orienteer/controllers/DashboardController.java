package com.orienteer.orienteer.controllers;

import com.orienteer.orienteer.models.Geocache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DashboardController {

    @GetMapping("/dash")
    public String dash(Model view){
        view.addAttribute("geocache", new Geocache());
        return "users/dashboard";
    }


    @GetMapping("dash/create")
    public String create(){
        return "geocaches/create";
    }
}
