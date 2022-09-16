package com.JavaProj.studentsystem.controller;

import com.JavaProj.studentsystem.exception.UserNotFoundException;
import com.JavaProj.studentsystem.model.User;
import com.JavaProj.studentsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

//    @GetMapping("/user/{name}")
//    User getUserByName(@PathVariable String name) {
//        return userRepository.findByName(String name);
//    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setHistory(newUser.getHistory());
                    user.setReservation(newUser.getReservation());
                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }
}
