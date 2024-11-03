package com.Kipper.First_Spring_App.service;

import com.Kipper.First_Spring_App.model.User;
import org. springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    private long idCounter = 1;

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(idCounter++);
        users.add(user);

        return user;
    }

    public Optional<User> findById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public boolean deleteById(Long id) {
        Optional<User> userToDelete = users.stream().filter(u -> u.getId().equals(id)).findFirst();

        if (userToDelete.isPresent()) {
            users.remove(userToDelete.get());

            return true;
        }

        return false;
    }
    public User update(Long id, User userDetail) {
        Optional<User> optionalUser = findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetail.getName());
            user.setEmail(userDetail.getEmail());

            return user;
        }
        return userDetail;
    }
}
