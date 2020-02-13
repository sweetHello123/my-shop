package com.china.myshop.web.api.dao;

import com.china.myshop.domain.TbUser;

/**
 * @author china wu
 */
public interface UserDao {

    TbUser login(TbUser tbUser);
}
