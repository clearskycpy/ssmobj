package com.cpy.service.impl;

import com.cpy.mapper.AccountsMapper;
import com.cpy.pojo.Accounts;
import com.cpy.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
// noRollbackForClassName = “name” name异常不回滚
public class AccountsServiceImpl implements AccountsService {
    @Autowired
    AccountsMapper accountsMapper;
    @Override
    public int save(Accounts accounts) {
        int num = 0;
        num = accountsMapper.save(accounts);
        System.out.println("增加成功num= "+ num);
//        手工抛出异常 添加事务如果出现异常就 事务回滚
//        System.out.println(1/0);

        return num;
    }




}
