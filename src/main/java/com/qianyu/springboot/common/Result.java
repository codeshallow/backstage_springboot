package com.qianyu.springboot.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qianyu
 * @title   接口返回统一包装类
 * @Package com.qianyu.springboot.common
 * @date 2022/3/30 15:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {



    private String code;
    private String msg;
    private Object data;

    public static Result success(){
        return new Result(Constants.CODE_200,"",null);
    }

    public static Result success(Object data){
        return new Result(Constants.CODE_200,"",data);
    }

    public static Result error(String code,String msg){
        return new Result(code,msg,null);
    }

    public static Result error(){
        return new Result(Constants.CODE_500,"系统错误",null);
    }
}
