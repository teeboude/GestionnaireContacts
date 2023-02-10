package com.example.gestionnairecontacts.controller;

import com.example.gestionnairecontacts.repository.entity.Contact;
import com.example.gestionnairecontacts.repository.entity.Relation;
import com.example.gestionnairecontacts.service.ContactService;
import com.example.gestionnairecontacts.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private RelationService relationService;

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
        model.addAttribute(contactService.getContact(id).get());
        return "contact-detail";
    }
    
    @GetMapping(path = "/create")
    public String displayContactCreate (Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact-create";
    }

    @PostMapping(path = "/create")
    public String contactCreate (@ModelAttribute Contact contact) {
        contactService.addContact(contact);
        return "redirect:list";
    }

    @GetMapping(path = "/update/{id}")
    public String displayContactUpdate (Model model, @PathVariable Long id) {
        Optional<Contact> contact = contactService.getContact(id);
        if (contact.isPresent()) {
            model.addAttribute("contact", contact.get());
            return "contact-update";
        } else {
            System.out.println("Ce contact n'existe pas!");
            return "redirect:contact-list";
        }
    }

    @PostMapping(path = "/update/{id}")
    public String contactUpdate (@ModelAttribute Contact contact) {
        contactService.addContact(contact);
        return "redirect:profile";
    }

    @GetMapping(path = "/update/relation/{id}")
    public String displayRelationCreate (Model model, @PathVariable Long id) {
        Relation relation = new Relation();
        relation.setContactEntree(contactService.getContact(id).get());
        model.addAttribute("relation", relation);
        List<Contact> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "relation-create";
    }

    @PostMapping(path = "/update/relation")
    public String relationCreate (Relation relation) {
        relationService.addRelation(relation);
        return "redirect:contact-detail";
    }


}
