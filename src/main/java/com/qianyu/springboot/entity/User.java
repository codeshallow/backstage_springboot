package com.qianyu.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "sys_user")
public class User {

    //mp已自动转换成驼峰

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    @JsonIgnore //忽略某个字段，不展示给前端
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
    @TableField(value = "avatar_url")   //指定数据库的字段
    private String avatar;

}
