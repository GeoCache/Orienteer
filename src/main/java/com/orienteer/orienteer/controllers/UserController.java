package com.orienteer.orienteer.controllers;

import com.orienteer.orienteer.models.Geocache;
import com.orienteer.orienteer.repositories.GeoCacheRepo;
import com.orienteer.orienteer.repositories.UsersRepository;
import com.orienteer.orienteer.models.User;

import com.orienteer.orienteer.services.GeocacheService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final GeoCacheRepo geocacheService;


    public UserController(UsersRepository usersRepository, PasswordEncoder passwordEncoder, GeoCacheRepo geocacheService) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.geocacheService = geocacheService;

    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new SecurityProperties.User());
        return "usersRepository/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersRepository.save(user);
        return "redirect:/login";
    }


    @GetMapping("/profile/{id}")
    public String showProfile(@PathVariable long id, Model view) {
        view.addAttribute("user", usersRepository.findUsersById(id));
        List<Geocache> geocacheList = geocacheService.findAllByFinder_Id(id);
        view.addAttribute("geocaches", geocacheList);
        return "users/profile";
    }

}

