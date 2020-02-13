package com.china.myshop.web.admin.service;

import com.china.myshop.domain.TbUser;

/**
 * @author china wu
 */
public interface LoginService {
    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);
}
