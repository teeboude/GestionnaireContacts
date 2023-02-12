package com.example.gestionnairecontacts.controller;

import com.example.gestionnairecontacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
