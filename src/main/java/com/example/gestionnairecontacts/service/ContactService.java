package com.example.gestionnairecontacts.service;

import com.example.gestionnairecontacts.repository.ContactRepository;
import com.example.gestionnairecontacts.repository.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;


    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    public Optional<Contact> getContact(Long id) {
        return contactRepository.findById(id);

    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public List<Contact> getContactSearch(String search) {
        List<Contact> contacts = contactRepository.findByFirstnameContainingOrLastnameContaining(search, search);
        return contacts;
    }

}
