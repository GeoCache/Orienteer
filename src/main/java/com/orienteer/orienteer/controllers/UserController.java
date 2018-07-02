//package com.orienteer.orienteer.controllers;
//
//import com.orienteer.orienteer.models.User;
//import com.orienteer.orienteer.repositories.Users;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class UserController {
//    private Users users;
//    private PasswordEncoder passwordEncoder;
//
//    public UserController(Users users, PasswordEncoder passwordEncoder) {
//        this.users = users;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @GetMapping("/sign-up")
//    public String showSignupForm(Model model) {
//        model.addAttribute("user", new SecurityProperties.User());
//        return "users/sign-up";
//    }
//
//    @PostMapping("/sign-up")
//    public String saveUser(@ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        users.save(user);
//        return "redirect:/login";
//    }
//
//    @GetMapping("/home")
//    public @ResponseBody String showSplash(Model view){
//        return "this is home";
//    }
//}