package com.cpy.pojo;

import java.util.List;

public class Customer {
//    Customer表对应的列名
    private Integer id;
    private String name;
    private Integer age;
//    外连接表
    private List<Orders> ordersList;

    public Customer() {
    }

    public Customer(Integer id, String name, Integer age, List<Orders> ordersList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ordersList = ordersList;
    }
    public Customer( String name, Integer age, List<Orders> ordersList) {
        this.name = name;
        this.age = age;
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ordersList=" + ordersList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
