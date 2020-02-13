package com.china.myshop.web.api.service.impl;

import com.china.myshop.domain.TbUser;
import com.china.myshop.web.api.dao.UserDao;
import com.china.myshop.web.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author china wu
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Override
    public TbUser login(TbUser tbUser) {
        TbUser user = userDao.login(tbUser);
        return user;
    }
}
