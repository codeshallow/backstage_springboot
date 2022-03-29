package com.qianyu.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    //@Autowired
    //private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /**
     * 新增和修改
     * @param user
     * @return
     */
    @PostMapping()
    public Boolean save(@RequestBody User user){
        //新增或者更新
        return userService.saveUser(user);

    }

    /**
     * 查询所有数据
     * @return
     */
    @GetMapping()
    public List<User> findAll() {
        return userService.list();
    }

    /**
     * 通过id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {//@PathVariable指{id}和id一一对应
        return userService.removeById(id);
    }

    @DeleteMapping("/batch/{id}")
    public Boolean deleteBatch(@RequestBody List<Integer> ids) {//@PathVariable指{id}和id一一对应
        return userService.removeByIds(ids);
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
    //@GetMapping("/page")    //借口路径：/user/page
    //public Map<String,Object> findPage(@RequestParam Integer pageNum,
    //                                   @RequestParam Integer pageSize,
    //                                   @RequestParam String username) {
    //
    //    pageNum = (pageNum - 1) * pageSize;
    //    username = "%" + username + "%";
    //    List<User> data = userMapper.selectPage(pageNum, pageSize,username);
    //    Integer total = userMapper.selectTotal(username);
    //    Map<String, Object> res = new HashMap<>();
    //    res.put("data",data);
    //    res.put("total",total);
    //    return res;
    //}

    /**
     * mybatis-plus实现分页查询
     * @param pageNum
     * @param pageSize
     * @param username
     * @return
     */
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username,
                                @RequestParam(defaultValue = "") String email,
                                @RequestParam(defaultValue = "") String address){
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //条件少有or，不然前面条件失效，尽量用and
        if (!"".equals(username)) {
            queryWrapper.like("username",username);

        }
        if (!"".equals(email)) {
            queryWrapper.like("email",email);

        }
        if (!"".equals(address)) {
            queryWrapper.like("address",address);

        }

        queryWrapper.orderByDesc("id");
        return userService.page(page,queryWrapper);
    }
}
