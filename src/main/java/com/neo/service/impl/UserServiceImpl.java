package com.neo.service.impl;

import com.neo.mapper.UserMapper;
import com.neo.model.User;
import com.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "UserService")
public class UserServiceImpl implements UserService {

    private Long id;
    private User user;

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        List<User> users = userMapper.getAll();
        return users;
    }

    public User getUser(Long id) {
        return userMapper.getById(id);
    }

    @Async("UserThreadPoolExecutor")
    public void addUser(User user) {
        userMapper.insert(user.getName(), user.getAge(), user.getAddress());
    }

    @Async("UserThreadPoolExecutor")
    public void updateUser(Long id, User user) {
        userMapper.update(id, user.getName(), user.getAge(), user.getAddress());
    }

    @Async("UserThreadPoolExecutor")
    public void deleteUser(Long id) {
        userMapper.delete(id);
    }

}
