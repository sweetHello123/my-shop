package com.china.myshop.web.api.service;

import com.china.myshop.domain.TbUser;

/**
 * @author china wu
 */
public interface LoginService {

    /** 用户登录接口
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
