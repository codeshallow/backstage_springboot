package com.qianyu.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianyu.springboot.entity.User;
import com.qianyu.springboot.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author qianyu
 * @title
 * @Package com.qianyu.springboot.service
 * @date 2022/3/28 17:17
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    public Boolean saveUser(User user) {
        //if (user == null) {
        //    //mybatis-plus提供的方法，表示插入数据
        //    return save(user);
        //}else {
        //    return updateById(user);
        //}

        return saveOrUpdate(user);

    }

    //@Autowired
    //private UserMapper userMapper;
    //
    //public int save(User user){
    //    if (user.getId() == null) {
    //        //user没有id，表示可以新增
    //        return userMapper.insert(user);
    //    }else {
    //        //否则为更新
    //        return userMapper.update(user);
    //    }
    //}


}
