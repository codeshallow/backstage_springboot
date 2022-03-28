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

    /**
     * 新增和修改
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Integer save(@RequestBody User user){
        //新增或者更新
        return userService.save(user);

    }

    /**
     * 查询所有数据
     * @return
     */
    @GetMapping("/all")
    public List<User> findAll() {
        List<User> all = userMapper.findAll();
        return all;
    }

    /**
     * 通过id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {//@PathVariable指{id}和id一一对应
        return userMapper.deleteById(id);
    }
}
