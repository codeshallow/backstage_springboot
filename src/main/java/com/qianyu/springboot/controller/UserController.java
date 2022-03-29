package com.qianyu.springboot.controller;

import com.qianyu.springboot.entity.User;
import com.qianyu.springboot.mapper.UserMapper;
import com.qianyu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @PostMapping()
    public Integer save(@RequestBody User user){
        //新增或者更新
        return userService.save(user);

    }

    /**
     * 查询所有数据
     * @return
     */
    @GetMapping()
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

    /**
     * 分页查询
     * @RequestParam 接收 ?pageNum=1&pigeSize=10 将前端路径值映射过来
     *
     * -- 结论：limit第一个参数 = (pageNUM -1) * pageSize
     * pageSize不变
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")    //借口路径：/user/page
    public Map<String,Object> findPage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam String username) {

        pageNum = (pageNum - 1) * pageSize;
        username = "%" + username + "%";
        List<User> data = userMapper.selectPage(pageNum, pageSize,username);
        Integer total = userMapper.selectTotal(username);
        Map<String, Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
