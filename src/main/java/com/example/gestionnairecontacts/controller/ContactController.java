package com.example.gestionnairecontacts.controller;

import com.example.gestionnairecontacts.repository.entity.Contact;
import com.example.gestionnairecontacts.repository.entity.User;
import com.example.gestionnairecontacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping(path = "/list")
    public String showContacts (Model model, @RequestParam(required = false) String search)   {
        List<Contact> contacts;
        if (search != null) {
            contacts = contactService.getContactSearch(search);
        } else {
            contacts = contactService.getAllContacts();
        }
        model.addAttribute("contacts", contacts);
        return "contact-list";
    }

    @GetMapping(path = "/list/{id}")
    public String showSingleContact (Model model, @PathVariable Long id) {
        model.addAttribute(contactService.getContact(id));
        return "contact-detail";
    }

    @GetMapping(path = "/contact-create")
    public String displayContactCreate (Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact-create";
    }

    @PostMapping(path = "/contact-create")
    public String contactCreate (@ModelAttribute Contact contact) {
        contactService.addContact(contact);
        return "redirect:list";
    }

    @GetMapping(path = "/contact-update/{id}")
    public String displayContactUpdate (Model model, @PathVariable Long id) {
        Contact contact = contactService.getContact(id);
        model.addAttribute("contact", contact);
        return "contact-create";
    }

    @PutMapping(path = "/contact-update/{id}")
    public String contactUpdate (@ModelAttribute Contact contact) {
        contactService.addContact(contact);
        return "redirect:profile";
    }
}
