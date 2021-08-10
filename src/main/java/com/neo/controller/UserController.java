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

    @GetMapping("/listAllUsers")
	public List<User> listAllUsers() {
		return userService.list();
	}

    @PostMapping("/addUser")
    //@Async("UserThreadPoolExecutor")
    public String addUser(@RequestBody User user) {
        userService.save(user);
        return "success";
    }

    @GetMapping("/{id}")
    @Cacheable(cacheNames ="users", key="'userId-' + #id", unless="#result == null")
    public User getUserById(@PathVariable Long id) {
	    return userService.getById(id);
    }

    @PutMapping("/{id}")
    @CacheEvict(cacheNames ="users", key="'userId-' + #id")
    @Async("UserThreadPoolExecutor")
    public void updateUserById(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        userService.updateById(user);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(cacheNames ="users", key="'userId-' + #id")
    @Async("UserThreadPoolExecutor")
    public void deleteUserById(@PathVariable Long id) {
        userService.removeById(id);
    }
    
}