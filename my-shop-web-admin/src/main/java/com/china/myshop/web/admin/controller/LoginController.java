package com.china.myshop.web.admin.controller;

import com.china.myshop.commons.utils.CookieUtils;
import com.china.myshop.domain.TbUser;
import com.china.myshop.web.admin.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: LoginController
 * @Description: 登录控制器
 * @author: china wu
 * @date: 2019\9\2 0002 15:22
 */
@Controller
public class LoginController {

    private static final String COOKIE_NAME_USER = "userInfo";

    @Autowired
    private LoginService loginService;

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping(value = {"/", "login"})
    public String login(HttpServletRequest request) {
        // 获取客户端cookie中的信息
        String userInfo = CookieUtils.getCookieValue(request, COOKIE_NAME_USER);

        if (StringUtils.isNotBlank(userInfo)) {
            String[] split = StringUtils.split(userInfo, ":");
            request.setAttribute("email", split[0]);
            request.setAttribute("password", split[1]);
            request.setAttribute("isRemember", true);
        }
        return "login";
    }

    /**
     * 登录页面
     *
     * @param email    邮箱
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password, @RequestParam(required = false) String isRemember,
                        HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println(isRemember);
        TbUser user = loginService.login(email, password);

        // 如果用户不勾选记住我，则删除cookie
        if (isRemember == null) {
            CookieUtils.deleteCookie(request, response, COOKIE_NAME_USER);
        }

        // 登录验证成功
        if (user != null) {
            // 如果勾选了记住我，则将用户登录信息保存到cookie中
            if (isRemember != null) {
                CookieUtils.setCookie(request, response, COOKIE_NAME_USER, String.format("%s:%s", email, password), 60 * 60 * 24 * 7);
            }
            request.getSession().setAttribute("session_user", user);
            return "index";
        } else {
            model.addAttribute("msg", "用户名或密码错误!");
            return "login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}