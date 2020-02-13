package com.china.myshop.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: HomeController
 * @Description: 主页控制器
 * @author: china wu
 * @date: 2019\9\4 0004 17:31
 */
@Controller
public class HomeController {
    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main() {
        return "index";
    }
}
