package com.example.gestionnairecontacts.service;

import com.example.gestionnairecontacts.repository.UserRepository;
import com.example.gestionnairecontacts.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, User newUser) {
        User oldUser = userRepository.findById(id).get();
        oldUser.setEmail(newUser.getEmail());
        oldUser.setFirstname(newUser.getFirstname());
        oldUser.setLastname(newUser.getLastname());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setPhoto(newUser.getPhoto());
        userRepository.save(oldUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUser(Long id) {
       User user = userRepository.findById(id).get();
    return user;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;

    }
}
