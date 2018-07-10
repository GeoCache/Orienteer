package com.orienteer.orienteer.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GeocacheController {

    @GetMapping("/geocache/create")
    public String showCreate() {
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
