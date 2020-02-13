package com.china.myshop.web.admin.service.impl;

import com.china.myshop.domain.TbUser;
import com.china.myshop.web.admin.dao.UserDao;
import com.china.myshop.web.admin.service.LoginService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName: LoginServiceImpl
 * @Description:
 * @author: china wu
 * @date: 2019\9\9 0009 21:24
 */
@Controller
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao tbUserDao;

    @Override
    public TbUser login(String email, String password) {
        TbUser user = tbUserDao.selectByEmail(email);
        if (user != null) {
            //Base64密码加密
            byte[] bytes = Base64.encodeBase64(password.getBytes(), true);
            String base64Password = new String(bytes);

            //去除加密后的回车换行符
            base64Password = base64Password.replaceAll("\r|\n", "");
            user.setPassword(base64Password);

            if (base64Password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
