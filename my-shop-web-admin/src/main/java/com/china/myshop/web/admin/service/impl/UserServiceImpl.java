package com.china.myshop.web.admin.service.impl;

import com.china.myshop.commons.dto.BaseResult;
import com.china.myshop.commons.dto.PageInfo;
import com.china.myshop.commons.validator.BeanValidator;
import com.china.myshop.domain.TbUser;
import com.china.myshop.web.admin.dao.UserDao;
import com.china.myshop.web.admin.service.UserService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @author: china wu
 * @date: 2019\8\29 0029 22:13
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public BaseResult save(TbUser user) {
        String msg = BeanValidator.validator(user);
        //验证不通过
        if (msg != null) {
            return BaseResult.fail(msg);
        }
        //验证通过
        else {
            //Base64密码加密
            byte[] bytes = Base64.encodeBase64(user.getPassword().getBytes(), true);
            String encodePassword = new String(bytes);
            //去除加密后的回车换行符
            encodePassword = encodePassword.replaceAll("\r|\n", "");
            user.setPassword(encodePassword);

            //重新设置当前的更新时间
            user.setUpdateTime(new Date());

            //id为空表示新增操作
            if (user.getId() == null) {
                //新增操作要设置当前的创建时间
                user.setCreateTime(new Date());
                userDao.insert(user);
            }
            //否则为编辑操作
            else {
                //查询所编辑的用户实体
                TbUser tbUser = userDao.selectByPrimaryKey(user.getId());
                //编辑时获取该实体的创建时间
                user.setCreateTime(tbUser.getCreateTime());
                userDao.update(user);
            }
            return BaseResult.success("保存数据成功");
        }
    }

    @Override
    public List<TbUser> list() {
        List<TbUser> users = userDao.selectAll();
        return users;
    }

    @Override
    public TbUser getById(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteMulti(String[] ids) {
        userDao.deleteByIds(ids);
    }

    @Override
    public PageInfo<TbUser> page(int draw, int start, int length, TbUser user) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("user", user);

        List<TbUser> users = userDao.selectByPage(params);

        int count = userDao.selectCount(user);

        PageInfo<TbUser> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(users);

        return pageInfo;
    }

    @Override
    public int count(TbUser tbUser) {
        return userDao.selectCount(tbUser);
    }
}
