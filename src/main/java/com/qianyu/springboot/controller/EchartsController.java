package com.qianyu.springboot.controller;

import cn.hutool.core.collection.CollUtil;
import com.qianyu.springboot.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyu
 * @title
 * @Package com.qianyu.springboot.controller
 * @date 2022/4/1 16:36
 */
@RestController
@RequestMapping("/echarts")
public class EchartsController {

    @GetMapping("/example")
    public Result get(){
        Map<String, Object> map = new HashMap<>();
        map.put("x", CollUtil.newArrayList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
        map.put("y",CollUtil.newArrayList(150, 230, 224, 218, 135, 147, 260));

        return Result.success(map);
    }
}
