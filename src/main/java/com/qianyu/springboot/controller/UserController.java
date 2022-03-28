package com.qianyu.springboot.controller;

import com.qianyu.springboot.entity.User;
import com.qianyu.springboot.mapper.UserMapper;
import com.qianyu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qianyu
 * @title
 * @Package com.qianyu.springboot.controller
 * @date 2022/3/28 16:38
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public Integer save(@RequestBody User user){
        //新增或者更新
        return userService.save(user);

    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/all")
    public List<User> findAll() {
        List<User> all = userMapper.findAll();
        return all;
    }
}
