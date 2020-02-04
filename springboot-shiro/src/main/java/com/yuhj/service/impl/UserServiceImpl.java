package com.yuhj.service.impl;

import com.yuhj.mapper.UserMapper;
import com.yuhj.pojo.User;
import com.yuhj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-security
 * @description: impl
 * @author: Yuhongjie
 * @create: 2020-01-31 12:57
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}