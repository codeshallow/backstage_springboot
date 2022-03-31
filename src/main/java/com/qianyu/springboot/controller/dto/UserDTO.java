package com.qianyu.springboot.controller.dto;

import lombok.Data;

/**
 * @author qianyu
 * @title   接收前端登录请求的参数
 * @Package com.qianyu.springboot.controller.dto
 * @date 2022/3/30 14:26
 */
@Data
public class UserDTO {

    private String username;
    private String password;
    private String nickname;
    private String avatarUrl;
    private String token;
}
