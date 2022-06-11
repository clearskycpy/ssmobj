package com.cpy.mapper;

import com.cpy.pojo.Orders;

public interface OrdersMapper {
//    根据主键查订单同时查询下此订单的客户信息
    Orders getById(Integer id);
}
