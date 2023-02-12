package com.example.gestionnairecontacts.controller;

import com.example.gestionnairecontacts.repository.entity.User;
import com.example.gestionnairecontacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/profile/{id}")
    public String showProfile (Model model, @PathVariable Long id) {
        model.addAttribute("user",userService.getUser(id));
        return "profile";
    }

    @GetMapping(path = "/profile-create")
    public String displayProfileCreate (Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "profile-create";
    }

    @PostMapping(path = "/profile-create")
    public String profileCreate (@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:profile";
    }

    @GetMapping(path = "/profile-update/{id}")
    public String displayProfileUpdate (Model model, @PathVariable Long id) {
        User user = userService.getUser(id);
        String message = "Modifier le profil " + user.getLastname() + " " + user.getFirstname();
        model.addAttribute("message", message);
        model.addAttribute("user", user);
        return "profile-update";
    }

    @PostMapping(path = "/profile-update/{id}")
    public String profileUpdate (@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/user/profile/"+user.getId();
    }


}
