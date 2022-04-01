package com.qianyu.springboot.service.impl;

import com.qianyu.springboot.entity.Role;
import com.qianyu.springboot.mapper.RoleMapper;
import com.qianyu.springboot.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 浅羽
 * @since 2022-04-02
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
