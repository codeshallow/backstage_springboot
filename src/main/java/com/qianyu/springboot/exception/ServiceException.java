package com.qianyu.springboot.exception;

import lombok.Getter;

/**
 * @author qianyu
 * @title   自定义异常
 * @Package com.qianyu.springboot.exception
 * @date 2022/3/30 15:36
 */
@Getter
public class ServiceException extends RuntimeException{

    private String code;

    public ServiceException(String code,String msg){
        super(msg);
        this.code = code;
    }

}
