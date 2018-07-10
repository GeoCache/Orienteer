package com.orienteer.orienteer.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GeocacheController {

    @GetMapping("/create")
    public String showCreate() {
        return "geocaches/create";
    }

    @GetMapping("/found")
    public String showFind() {
        return "geocaches/found";
    }

    @GetMapping("/list")
    public String showList() {
        return "geocaches/list";
    }


}
