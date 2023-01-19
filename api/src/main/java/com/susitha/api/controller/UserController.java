package com.susitha.api.controller;

import com.susitha.api.entity.User;
import com.susitha.api.exception.ResourceNotFoundException;
import com.susitha.api.repository.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get")
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") long userId){
        return this.userRepository.findById(userId)
                .orElseThrow(()->( new ResourceNotFoundException("User Not Found with Id "+userId)));
    }

    @PostMapping("/create")
    public User creaateUser(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") long userId){
        User existingUser;
        existingUser = this.userRepository.findById(userId)
                .orElseThrow(()->(new ResourceNotFoundException("User not found in the Id "+userId)));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return this.userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id){
        User existingUser = this.userRepository.findById(id)
                .orElseThrow(()->(new ResourceNotFoundException("User not found in the Id "+id)));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }



}
