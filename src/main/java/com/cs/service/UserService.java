package com.cs.service;

import com.cs.pojo.User;

public interface UserService {
    /*根据用户账户查找用户信息*/
    User getUserByAccount(String account);
    /*添加用户*/
    int addUser(User user);
    /*修改用户信息*/
    int updateUser(String account, User user);

}
