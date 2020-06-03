package com.lyy.service.impl;

import com.lyy.mapper.UserMapper;
import com.lyy.model.User;
import com.lyy.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:com.lyy.service.impl
 * @Author:lyy
 * @Date:2020/6/3
 * @version:0.0.0.1
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(User user) {
    User u = userMapper.selByNameAndPassword(user);
        return u;
    }

    @Override
    public int addUser(User user) {
        int index = userMapper.insertUser(user);
        return index;
    }

    @Override
    public List<User> selUser(User user) {
        List<User> list = userMapper.selUser(user);

        return list ;
    }

    @Override
    public int updateUser(User user) {
       int index =  userMapper.updateUser(user);

        return index;
    }
}
