package com.china.myshop.web.api.controller;

import com.china.myshop.commons.dto.BaseResult;
import com.china.myshop.domain.TbUser;
import com.china.myshop.web.api.dto.UserDTO;
import com.china.myshop.web.api.service.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2019/12/19 20:55
 */
@RestController
@RequestMapping(value = "/api/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(TbUser tbUser) {
        TbUser user = loginService.login(tbUser);

        if (user == null) {
            return BaseResult.fail("用户名或密码错误");
        } else {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user,userDTO);
            return BaseResult.success("成功", userDTO);
        }
    }
}
