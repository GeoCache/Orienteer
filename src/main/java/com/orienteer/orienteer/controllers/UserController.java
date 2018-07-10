package com.orienteer.orienteer.controllers;

import com.orienteer.orienteer.repositories.UsersRepository;
import com.orienteer.orienteer.models.User;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new SecurityProperties.User());
        return "usersRepository/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersRepository.save(user);
        return "redirect:/login";
    }



    @GetMapping("/profile")
    public String dash(){
        return "users/profile";
    }

}

