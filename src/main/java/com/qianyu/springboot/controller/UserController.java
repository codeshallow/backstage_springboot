package com.qianyu.springboot.controller;

import com.qianyu.springboot.entity.User;
import com.qianyu.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qianyu
 * @title
 * @Package com.qianyu.springboot.controller
 * @date 2022/3/28 16:38
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/")
    public List<User> index() {
        List<User> all = userMapper.findAll();
        return all;
    }
}
