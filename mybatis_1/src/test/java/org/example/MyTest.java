package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.pojo.Student;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * 学生表的增删改查
 */
public class MyTest {
    static SqlSessionFactory factory = null;
    static SqlSession session = null;
    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
            session = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void after(){
        session.commit();
        session.close();
    }
    @Test
    public void testSelect(){
        List<Student> list = session.selectList("cpy.getAll");
        for (Student s : list){
            System.out.println(s);
        }
    }
    @Test  // 查询数据
    public void testSelectId(){
        Student student = session.selectOne("cpy.getID",4);
        System.out.println(student);
    }
    @Test  // 插入数据
    public void insertTest(){

        int num = session.insert("cpy.insert",new Student("he23中","ccc.com",45));
        System.out.println(num);
    }

    @Test   // 删除数据
    public void deleteTest(){
        int num = session.delete("cpy.delete",1);
        System.out.println(num);
    }


    @Test // 更新数据
    public void updateTest(){
        int num = session.update("cpy.update",new Student(3,"hhdhdhd","www.baidu.com",40));
        System.out.println(num);
    }


}
