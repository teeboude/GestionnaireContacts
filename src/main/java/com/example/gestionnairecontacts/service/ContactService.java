package com.example.gestionnairecontacts.service;

import com.example.gestionnairecontacts.repository.ContactRepository;
import com.example.gestionnairecontacts.repository.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    public Contact getContact(Long id) {
        Contact contact = contactRepository.findById(id).get();
        return contact;
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts;
    }

    public List<Contact> getContactSearch(String search) {
        List<Contact> contacts = contactRepository.findByFirstnameContainingOrLastnameContaining(search, search);
        return contacts;
    }

}
