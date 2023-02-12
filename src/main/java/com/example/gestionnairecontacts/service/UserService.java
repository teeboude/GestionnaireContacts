package com.example.gestionnairecontacts.service;

import com.example.gestionnairecontacts.repository.UserRepository;
import com.example.gestionnairecontacts.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUser(Long id) {
       User user = userRepository.findById(id).get();
    return user;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;

    }

    public boolean tryConnection(String email, String passwordEntered) {
        boolean connected = false;
        Optional<User> user = Optional.empty();
        try{
            user = userRepository.findUserByEmail(email);
        } catch (Exception e) {
            System.out.println("Pas d'accès : "+e);
        }

        if (user.isPresent()) {
            if (passwordEntered.equals(user.get().getPassword())) {
                connected = true;
            }
        }
        return connected;
    }

}
