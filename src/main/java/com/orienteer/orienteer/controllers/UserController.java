package com.orienteer.orienteer.controllers;

import com.orienteer.orienteer.models.User;
import com.orienteer.orienteer.repositories.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private User user;
    private PasswordEncoder passwordEncoder;

    public UserController(User user, PasswordEncoder passwordEncoder) {
        this.user = user;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new SecurityProperties.User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute SecurityProperties.User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        User.save();
        return "redirect:/login";
    }
}