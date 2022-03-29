package com.qianyu.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author qianyu
 * @title
 * @Package com.qianyu.springboot.entity
 * @date 2022/3/28 16:06
 */
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class User {

    private Integer id;
    private String username;
    @JsonIgnore //忽略某个字段，不展示给前端
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;

}
