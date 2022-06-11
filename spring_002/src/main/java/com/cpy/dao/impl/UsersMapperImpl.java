package com.cpy.dao.impl;

import com.cpy.pojo.Users;

public class UsersMapperImpl implements com.cpy.dao.UsersMapper {
    @Override
    public int insert(Users users) {
        System.out.println(users.getUname()+"添加成功");
        return 1;
    }
}
