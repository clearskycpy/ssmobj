package com.cpy.controller;

import com.cpy.pojo.Users;
import com.cpy.service.UsersService;
import com.cpy.service.impl.UsersServiceImpl;

// 界面层 代替 Servlet
public class UsersController {
//    界面层的功能实现 使用 spring注入
    UsersService usersService ;

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    public int insert(Users users){
        return usersService.insert(users);
    }
}
