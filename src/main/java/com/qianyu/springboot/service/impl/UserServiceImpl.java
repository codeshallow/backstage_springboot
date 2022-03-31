package com.qianyu.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qianyu.springboot.common.Constants;
import com.qianyu.springboot.controller.dto.UserDTO;
import com.qianyu.springboot.entity.User;
import com.qianyu.springboot.exception.ServiceException;
import com.qianyu.springboot.mapper.UserMapper;
import com.qianyu.springboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 浅羽
 * @since 2022-03-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private static final Log LOG = Log.get();

    @Override
    public UserDTO login(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if (one != null) {
            BeanUtil.copyProperties(one, userDTO, true);
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }


    }

    @Override
    public User register(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if (one == null) {
            one = new User();
            BeanUtil.copyProperties(userDTO,one,true);
            //把copy完之后的用户对象存储到数据库
            save(one);
        }else {
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }
        return one;

    }

    /**
     * 单独封装一个方法获取获取用户
     * @param userDTO
     * @return
     */
    private User getUserInfo(UserDTO userDTO){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        queryWrapper.eq("password", userDTO.getPassword());
        User one;
        // 处理异常情况
        try {
            //从数据库查询用户信息
            one = getOne(queryWrapper);
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }
}
