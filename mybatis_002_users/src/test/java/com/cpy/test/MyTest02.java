package com.cpy.test;

import com.cpy.mapper.BookMapper;
import com.cpy.mapper.CustomerMapper;
import com.cpy.mapper.OrdersMapper;
import com.cpy.mapper.UserMapper;
import com.cpy.pojo.Customer;
import com.cpy.pojo.Orders;
import com.cpy.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class MyTest02 {
    SqlSession session ;
    CustomerMapper customerMapper;
    OrdersMapper ordersMapper;
    //    日期格式化
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Before
    public void openSqlSession() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        //        取出动态代理对象
        customerMapper = session.getMapper(CustomerMapper.class);
        ordersMapper = session.getMapper(OrdersMapper.class);
    }

    @After
    public void closeSqlSession(){
        session.close();
    }

//    一对多查询  存在问题
    @Test
    public void testGetCustomerById(){
        Customer customer = customerMapper.getById(2);
        System.out.println(customer);
    }

//    多对一查询
    @Test
    public void testGetById(){
        Orders orders = ordersMapper.getById(11);
        System.out.println(orders);
    }
//    验证一级缓存
    @Test
    public void testhuancun(){
        UserMapper usermapper = session.getMapper(UserMapper.class);
//        取出来的对象是同一个对象 说明是从 session里面取出来的 而且没有再调用数据库这个过程

        Users users = usermapper.getById(3);
        System.out.println(users);
        System.out.println("**********************************************");
        Users users1 = usermapper.getById(3);
        System.out.println(users1 == users);
    }


}
