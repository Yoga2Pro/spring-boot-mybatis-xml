package com.neo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.neo.model.User;
import com.neo.mapper.UserMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;

@RestController
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在/users下
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/")
	public List<User> getUsers() {
		List<User> users=userMapper.getAll();
		return users;
	}
	
    @GetMapping("/{id}")
    // 指redis在partition"users"的id(key="#id"自动找input的id)下存value
    @Cacheable(value="users", key="#id")
    public User getUser(@PathVariable Long id) {
        return userMapper.getById(id);
    }

    @PostMapping("/")
    public String postUser(@RequestBody User user) {
        // @RequestBody注解用来绑定通过http请求中application/json类型上传的数据
        userMapper.insert(user.getName(), user.getAge(), user.getAddress());
        return "success";
    }

    @PutMapping("/{id}")
    @CacheEvict(value="users", key="#id")
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        userMapper.update(id, user.getName(), user.getAge(), user.getAddress());
        return "success";
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value="users", key="#id")
    public String deleteUser(@PathVariable Long id) {
        userMapper.delete(id);
        return "success";
    }
    
}