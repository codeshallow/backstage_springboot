package com.qianyu.springboot.mapper;

import com.qianyu.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author qianyu
 * @title
 * @Package com.qianyu.springboot.mapper
 * @date 2022/3/28 16:12
 */
@Mapper
public interface UserMapper {

    @Select("select * from sys_user")
    List<User> findAll();

    @Insert("INSERT INTO sys_user(username,password,nickname,email,phone,address) VALUES(#{username},#{password},#{nickname},#{email},#{phone},#{address})")
    int insert(User user);

    int update(User user);

    @Delete("delete from sys_user where id = #{id}")
    Integer deleteById(@Param("id") Integer id);
}
