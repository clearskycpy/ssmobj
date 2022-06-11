package com.cpy.service.impl;

import com.cpy.dao.UsersMapper;
import com.cpy.dao.impl.UsersMapperImpl;
import com.cpy.pojo.Users;
import com.cpy.service.UsersService;

public class UsersServiceImpl implements UsersService {

    private UsersMapper usersMapper;

    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public int insert(Users users) {
//        添加更复杂的业务逻辑
        return usersMapper.insert(users);
    }
}
