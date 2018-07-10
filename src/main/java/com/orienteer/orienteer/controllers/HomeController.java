package com.orienteer.orienteer.controllers;


import com.orienteer.orienteer.models.User;
import com.orienteer.orienteer.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private UsersRepository users;
    private PasswordEncoder passwordEncoder;

    public HomeController(UsersRepository users, PasswordEncoder passwordEncoder){
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String helloWorld(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }

    @PostMapping("/")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

}
