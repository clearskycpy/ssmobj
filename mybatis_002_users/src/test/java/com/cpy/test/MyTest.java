package com.cpy.test;

import com.cpy.mapper.BookMapper;
import com.cpy.mapper.UserMapper;
import com.cpy.pojo.Book;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyTest {
    SqlSession session ;
    UserMapper umapper ;
    BookMapper bookMapper;
//    日期格式化
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Before
    public void openSqlSession() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        //        取出动态代理对象
        umapper = session.getMapper(UserMapper.class);
        bookMapper = session.getMapper(BookMapper.class);
    }

    @After
    public void closeSqlSession(){
        session.close();
    }

    @Test
    public void testGetAll(){
//        采用了jdk动态代理的方式
        List<Users> users = umapper.selectAll();
        System.out.println(umapper.getClass());  // class com.sun.proxy.$Proxy7
        users.forEach(users1 -> System.out.println(users1));
    }

    /**
     * 根据id查询用户
     */
    @Test
    public void testGetById(){
        Users u = umapper.getById(1);
        System.out.println(u);
    }

    /**
     * 根据name like 查询用户
     */
    @Test
    public void testLikeGet(){
        List<Users> list= umapper.likeGet("aa");
        list.forEach(users -> System.out.println(users));
    }

    /**
     * 根据address like 查询用户
     */
    @Test
    public void testLikeGetPlus(){
        List<Users> list= umapper.likeGetPlus("address","江西");
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void testUUID(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
//        一般使用的时候会将-替换成“”  、、 可以用来生成各种随机的串 比如拼接时间戳等等
        System.out.println(uuid.toString().replace("-","").substring(20));
    }

    @Test
    public void testSelectMore(){
        Users user = new Users();
        user.setSex("男");
        List<Users> list = umapper.selectMore(user);
        list.forEach(users -> System.out.println(users));
    }

    @Test
    public void testUpdateNew(){
        Users user = new Users();
        user.setId(3);
        user.setUserName("zzq");
        user.setSex("女");
        int res = umapper.updateNew(user);
        session.commit();   // 提交事务
        System.out.println(res == 1 ? "更新成功" : "更新失败");
    }

//    插入一组用户
    @Test
    public void testInsert(){
        Date date = new Date();
        long time =  date.getTime();

        for (int i = 0; i < 20; i++) {
            time -= 1000*60*60*24*30*12;
            Users user = new Users();
            user.setUserName(UUID.randomUUID().toString().replace("-","").substring(27)+"Q");
            if (i%2 == 1)  user.setSex("女");
            else user.setSex("男");
            user.setAddress(UUID.randomUUID().toString().replace("-","").substring(26)+"Address");
            user.setBirthday(new Date(time));
            int result = umapper.insert(user);
            System.out.println(result == 1 ? "true": "false");
        }
        session.commit();

    }

    @Test
    public void testInsert1(){
        umapper.insert(new Users("bbc",new Date() ,"男","上海"));
        session.commit();
    }

    @Test
    /**
     * 测试批量查询
     */
    public void testGetByIds(){
        Integer[] array = {2,4,6};
        List<Users> users = umapper.getByIds(array);
        users.forEach(users1 -> System.out.println(users1));
    }

    @Test
    /**
     * 测试批量删除
     */
    public void testDeleteBatch(){
        Integer[] array = {20,14,21};
        int s = umapper.deleteBatch(array);
        System.out.println(s);
        session.commit();
    }

    @Test
    /**
     * 批量增加
     */
    public void testInserts() throws ParseException {
        List<Users> list = new ArrayList<>();
        Users users = new Users("喜欢",format.parse("2002-08-23"),"男","朝阳");
        Users users1 = new Users("时候",format.parse("2002-08-23"),"男","朝阳");
        Users users2 = new Users("什么",format.parse("2002-08-23"),"男","朝阳");
        list.add(users);
        list.add(users2);
        list.add(users1);
        int bb = umapper.inserts(list);
        System.out.println(bb);
        session.commit();
    }


    @Test
    /**
     * 查询指定日期范围内的user
     */
    public void testBirthday() throws ParseException {
        List<Users> users = umapper.getByBirthday(format.parse("2022-01-01"),format.parse("2022-12-01"));
        users.forEach(users1 -> System.out.println(users1));
    }

//    入参是map
    @Test
    public void testMap() throws ParseException {
        Map map = new HashMap();
        map.put("arg0",format.parse("2022-01-01"));
        map.put("arg1",format.parse("2022-12-01"));
        List<Users> users = umapper.getByMap(map);
        users.forEach(users1 -> System.out.println(users1));
    }

//    返回值是map集合
    @Test
    public void testGetResMap(){
        Map map = umapper.getResMap(1);
        System.out.println(map);

    }

//    返回值是多个map
    @Test
    public void testGetMaps(){
        List<Map> list = umapper.getMaps();
        list.forEach(map -> System.out.println(map));
    }


//    列名不一致
    @Test
    public void testGetAllBook(){
        List<Book> books = bookMapper.getAll();
        books.forEach(book -> System.out.println(book));
    }

}


