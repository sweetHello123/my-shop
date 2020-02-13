package com.china.myshop.web.admin.dao;

import com.china.myshop.commons.persistence.BaseDao;
import com.china.myshop.domain.TbUser;

public interface UserDao extends BaseDao<TbUser> {

    TbUser selectByEmail(String email);

}