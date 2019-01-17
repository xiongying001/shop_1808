package com.qianfeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @Author 落花飘香
 * @Date 2019/1/16
 */
@Controller
public class IndexController {
    @RequestMapping("/toPage/{page}")
    public String toPage(@PathVariable("page") String page){

        return page;
    }

}
