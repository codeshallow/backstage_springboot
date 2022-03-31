package com.qianyu.springboot.service;

import com.qianyu.springboot.controller.dto.UserDTO;
import com.qianyu.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 浅羽
 * @since 2022-03-30
 */
public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);
}
