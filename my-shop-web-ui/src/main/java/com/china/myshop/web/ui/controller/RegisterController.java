package com.china.myshop.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2019/12/24 17:33
 */
@Controller
public class RegisterController {

    /**
     *
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register() {
        return "register";
    }
}
