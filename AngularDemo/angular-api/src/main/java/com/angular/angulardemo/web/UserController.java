package com.angular.angulardemo.web;

import com.angular.angulardemo.data.UserRepository;
import com.angular.angulardemo.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers()
    {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user)
    {
        System.out.println(user);
        userRepository.save(user);
    }

}
