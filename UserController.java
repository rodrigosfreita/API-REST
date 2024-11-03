package com.Kipper.First_Spring_App.controller;

import com.Kipper.First_Spring_App.model.User;
import com.Kipper.First_Spring_App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation. *;

import java.util.List;

@RestController
@RequestMapping ("/api/users")
public class UserController {

        @Autowired
        private UserService userService;

        @GetMapping
        public List<User> getAllUsers(){
            return userService.findAll();
        }

       @PostMapping
        public User CreateUser(@RequestBody User user){
            return  userService.save(user);
        }

        @GetMapping("/{id}")
            public User getUserById(@PathVariable Long id){
             return userService.findById(id).orElse(null);
        }

       @DeleteMapping("/{id}")
        public boolean deleteById(@PathVariable Long id){
            return userService.deleteById(id);
       }

       @PutMapping("/{id}")
        public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User userdetails){
          User updatedUser = userService.update(id,userdetails);

          if (updatedUser != null){
              return ResponseEntity.ok(updatedUser);
           }
          return ResponseEntity.notFound().build();
       }
}
