package com.orienteer.orienteer.controllers;


import com.orienteer.orienteer.models.Geocache;
import com.orienteer.orienteer.models.User;
import com.orienteer.orienteer.repositories.UsersRepository;
import com.orienteer.orienteer.services.GeocacheService;
import com.orienteer.orienteer.services.UserServices;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GeocacheController {

    private final GeocacheService geocacheService;
    private final UsersRepository usersRepository;

    public GeocacheController(GeocacheService geocacheService, UsersRepository usersRepository) {
        this.geocacheService = geocacheService;
        this.usersRepository = usersRepository;
    }

    @GetMapping("/geocache")
    public String index(Model view) {

        List<Geocache> geocaches;
        geocaches = geocacheService.findAll();
        view.addAttribute("geocaches", geocaches);
        return "geocache/index";
    }

    @GetMapping("/geocache/create")
    public String create(Model view) {
     view.addAttribute("geocache", new Geocache());
        return "geocaches/create";
    }

    @PostMapping("/geocache/create")
    public String saveGeocahe(@ModelAttribute Geocache geocache){
        geocacheService.save(geocache);
        return "redirect:/dash";
    }




    @GetMapping("/geocache/found")
    public String showFind() {
        return "geocaches/found";
    }

//    @GetMapping("/geocache/list")
//    public String showList() {
//        return "geocaches/list";
//    }


    @GetMapping("/geocache/{id}")
    public String show(@PathVariable long id, Model view) {
        Geocache geocache = geocacheService.findById(id);
        view.addAttribute("geocache", geocache);
        return "geocache/show";
    }

    @GetMapping("/geocache/{id}/edit")
    public String edit(@PathVariable long id, Model view) {
        Geocache geocache = geocacheService.findById(id);
        view.addAttribute("geocache", geocache);
        return "geocache/edit";
    }

    @PostMapping("/geocache/{id}/edit")
    public String updateGeo(@PathVariable long id, @ModelAttribute Geocache geocache){
        geocacheService.save(geocache);
        return "redirect:/dash";

    }

}