package com.cpy.mapper;

import com.cpy.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 数据访问层接口
 */
public interface UserMapper {

    /**
     * 查询全部
     * @return
     */
    List<Users> selectAll();

    /**
     * 按照id查询
     */
    Users getById(int id);

    /**
     * 更新用户
     * @param users
     * @return
     */
    int update(Users users);

    /**
     * 优化后的模糊查询
     * @param name
     * @return
     */
    List<Users> likeGet(String name);

    /**
     * 当参数是不好定义的时候可以使用param注解包装
     * @param type
     * @param value
     * @return
     */
    List<Users> likeGetPlus(
            @Param("lie")
            String type ,
            @Param("value")
            String value);

    /**
     * 插入一个用户并且返回主键值
     * @param users
     * @return
     */
    int insert(Users users);

    /**
     * 按照指定条件查询
     */
    List<Users> selectMore(Users users);

    /**
     * 有选择的更新 。没有赋值的不更新  使用到了set标签
     * @param users
     * @return
     */
    int updateNew(Users users);

    /**
     * 通过id查询多个用户
     */
    List<Users> getByIds(Integer[] arr);

//    批量删除
    int deleteBatch(Integer[] arr);

//    批量增加
    int inserts(List<Users> user);


//    查询日期范围
    List<Users> getByBirthday(Date begin , Date end);

//    入参是map类型的
    List<Users> getByMap(Map map);


//    返回值是map
    Map getResMap(Integer id);

//    返回值是map集合
    List<Map> getMaps();
}
