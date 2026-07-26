package com.csp.lbms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.csp.lbms.dto.RegisterDto;
import com.csp.lbms.entity.User;
import com.csp.lbms.repository.UserRepository;

@Controller
public class AuthController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new RegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") RegisterDto dto, Model model) {

        // ✅ Password match validation
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }

        // ✅ Username exists validation
        if (repository.existsByUsername(dto.getUsername())) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }

        // ✅ Role validation — prevent empty or tampered role values
        String selectedRole = dto.getRole();
        if (selectedRole == null ||
            (!selectedRole.equals("ROLE_USER") && !selectedRole.equals("ROLE_ADMIN"))) {
            model.addAttribute("error", "Invalid role selected");
            return "register";
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        // ✅ Use role from form instead of hardcoded ROLE_USER
        user.setRole(selectedRole);

        repository.save(user);

        model.addAttribute("success", "Registration successful! Please login.");
        return "login";
    }
}