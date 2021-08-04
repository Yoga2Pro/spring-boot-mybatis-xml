package com.neo.controller;

import java.util.List;

import com.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import com.neo.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
    @GetMapping("/{id}")
    @Cacheable(value="users", key="#id", unless="#result == null")
    public User getUser(@PathVariable Long id) {
	    return userService.getUser(id);
    }

    @PostMapping("/")
    @Async("UserThreadPoolExecutor")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/{id}")
    @CacheEvict(value="users", key="#id")
    @Async("UserThreadPoolExecutor")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value="users", key="#id")
    @Async("UserThreadPoolExecutor")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
}