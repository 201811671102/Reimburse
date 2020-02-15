package com.cs.service.impl;

import com.cs.mapper.UserMapper;
import com.cs.pojo.User;
import com.cs.pojo.UserExample;
import com.cs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByAccount(String account) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(account);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size()==1){
            return userList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public int addUser(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(user.getAccount());
        if( userMapper.selectByExample(userExample).isEmpty()){
            return userMapper.insertSelective(user);
        }
        return 400;
    }

    @Override
    public int updateUser(String account, User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(account);
        return userMapper.updateByExampleSelective(user,userExample);
    }
}
