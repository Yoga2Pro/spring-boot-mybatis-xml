package com.neo.service.impl;

import com.neo.mapper.UserMapper;
import com.neo.model.User;
import com.neo.service.UserService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}