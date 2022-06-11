package com.cpy.mapper;
import com.cpy.pojo.Customer;

public interface CustomerMapper {
//    根据id查询所有的信息和名下所有的订单
    Customer getById(Integer id);
}
