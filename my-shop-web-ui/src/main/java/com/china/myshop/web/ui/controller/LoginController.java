package com.china.myshop.web.ui.controller;

import com.china.myshop.commons.dto.BaseResult;
import com.china.myshop.commons.utils.SendEmailUtils;
import com.china.myshop.web.ui.api.UsersApi;
import com.china.myshop.web.ui.dto.User;
import com.google.code.kaptcha.Constants;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author china wu
 */
@Controller
public class LoginController {

    @Autowired
    private SendEmailUtils sendEmailUtils;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest request) throws EmailException {
        if (!checkCode(user, request)) {
            model.addAttribute("BaseResult", BaseResult.fail("验证码不正确，请重新输入"));
            return "login";
        }

        User u = UsersApi.login(user);

        if (u == null) {
            model.addAttribute("BaseResult", BaseResult.fail("用户名或密码错误，请重新输入"));
            return "login";
        }

        sendEmailUtils.send("用户登录", String.format("用户[%s]登录成功", u.getUsername()), "18896820691@163.com");

        request.getSession().setAttribute("session_user", user);
        return "redirect:/index";
    }

    /**
     * 注销
     * @param request
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }


    /**
     * 校验验证码
     * @param user
     * @param request
     * @return
     */
    private boolean checkCode(User user,HttpServletRequest request) {
        String code = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (code.equals(user.getVfCode())) {
            return true;
        }
        return false;
    }
}
