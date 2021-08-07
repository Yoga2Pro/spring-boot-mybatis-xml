package com.neo.controller;

import java.util.List;

import com.neo.service.UserService;
import com.neo.service.WorkerNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import com.neo.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;

import javax.annotation.Resource;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private WorkerNodeService workerNodeService;

    @GetMapping("/")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
    @GetMapping("/{id}")
    @Cacheable(cacheNames ="users", key="'userId-' + #id", unless="#result == null")
    public User getUser(@PathVariable Long id) {
	    return userService.getUser(id);
    }

    @PostMapping("/")
    @Async("UserThreadPoolExecutor")
    public void addUser(@RequestBody User user) {
        long id = workerNodeService.genUid();
        userService.addUser(id, user);
    }

    @PutMapping("/{id}")
    @CacheEvict(cacheNames ="users", key="'userId-' + #id")
    @Async("UserThreadPoolExecutor")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(cacheNames ="users", key="'userId-' + #id")
    @Async("UserThreadPoolExecutor")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
}