package org.example;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.pojo.Student;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void testSelect() throws IOException {
//        读取核心配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        创建SqlSessionFactory 工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        得到session对象
        SqlSession sqlSession = factory.openSession();
        List<Student> list = sqlSession.selectList("cpy.getAll");
        for (Student s : list){
            System.out.println(s);
        }

        //        关闭会话
        sqlSession.close();
    }

    @Test
    public void testByName() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        List<Student> list = session.selectList("cpy.getByName", "张");
        list.forEach(student -> System.out.println(student));
        session.close();
    }

}
