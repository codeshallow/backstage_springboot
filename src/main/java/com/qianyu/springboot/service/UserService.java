package com.qianyu.springboot.service;

import com.qianyu.springboot.entity.User;
import com.qianyu.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qianyu
 * @title
 * @Package com.qianyu.springboot.service
 * @date 2022/3/28 17:17
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int save(User user){
        if (user.getId() == null) {
            //user没有id，表示可以新增
            return userMapper.insert(user);
        }else {
            //否则为更新
            return userMapper.update(user);
        }
    }
}
