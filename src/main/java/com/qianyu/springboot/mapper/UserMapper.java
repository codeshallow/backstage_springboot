package com.qianyu.springboot.mapper;

import com.qianyu.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
