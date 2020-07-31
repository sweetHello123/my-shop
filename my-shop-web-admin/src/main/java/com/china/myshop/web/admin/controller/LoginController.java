package com.china.myshop.web.admin.controller;

import com.china.myshop.domain.TbUser;
import com.china.myshop.web.admin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: LoginController
 * @Description: 登录控制器
 * @author: china wu
 * @date: 2019\9\2 0002 15:22
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping(value = {"/", "login"})
    public String login() {
        return "login";
    }

    /**
     * 登录页面
     *
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password,
                        HttpServletRequest request, Model model) {
        TbUser user = loginService.login(email, password);

        if (user != null) {
            request.getSession().setAttribute("session_user", user);
            return "index";
        }
        model.addAttribute("msg", "用户名或密码错误!");
        return "login";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }
}