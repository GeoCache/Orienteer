package com.orienteer.orienteer.controllers;


import com.orienteer.orienteer.models.Geocache;
import com.orienteer.orienteer.services.GeocacheService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GeocacheController {

    private final GeocacheService geocacheService;
    private final UserController userController;

    public GeocacheController(GeocacheService geocacheService, UserController userController) {
        this.geocacheService = geocacheService;
        this.userController = userController;
    }

    @GetMapping("/geocache")
    public String index() {
        return "geocache/index";
    }

    @GetMapping("/geocache/create")
    public String create(Model view) {
     view.addAttribute("geocache", new Geocache());
        return "geocaches/create";
    }



    @GetMapping("/geocache/found")
    public String showFind() {
        return "geocaches/found";
    }

    @GetMapping("/geocache/list")
    public String showList() {
        return "geocaches/list";
    }


}
