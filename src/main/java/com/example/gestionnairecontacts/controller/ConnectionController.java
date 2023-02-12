package com.example.gestionnairecontacts.controller;

import com.example.gestionnairecontacts.repository.entity.User;
import com.example.gestionnairecontacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static java.awt.SystemColor.window;


@Controller
@RequestMapping("/connection")
public class ConnectionController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/")
    public String displayConnection(Model model) {
        model.addAttribute("message", "Se connecter");
        return "connection";
    }

    @PostMapping(path = "/")
    public String getConnection(@RequestParam String email, @RequestParam String password, RedirectAttributes redattri) {
        if (userService.tryConnection(email, password)) {
            return "redirect:/contact/list";
        } else {
            redattri.addFlashAttribute("error","Utilisateur non-existant ou saisies erronées");
            return "redirect:/connection/";
        }
    }

    // Inscription si utilisateur non existant
    @GetMapping(path = "/register")
    public String displayProfileCreate (Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping(path = "/register")
    public String profileCreate (@ModelAttribute User user) {
        userService.addUser(user);
        return "connection";
    }
}
