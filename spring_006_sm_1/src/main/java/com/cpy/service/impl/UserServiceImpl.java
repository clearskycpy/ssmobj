package com.cpy.service.impl;

import com.cpy.mapper.UserMapper;
import com.cpy.pojo.User;
import com.cpy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  //交个Spring管理
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(User user) {
//        处理业务逻辑
        return userMapper.insert(user);
    }
}
