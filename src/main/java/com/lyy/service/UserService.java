package com.lyy.service;

import com.lyy.model.User;


import java.util.List;

/**
 * @Description:com.lyy.service
 * @Author:lyy
 * @Date:2020/6/3
 * @version:0.0.0.1
 */

public interface UserService {
    User login(User user);
    int addUser(User user);
    List<User> selUser(User user);
    int updateUser(User user);

}
