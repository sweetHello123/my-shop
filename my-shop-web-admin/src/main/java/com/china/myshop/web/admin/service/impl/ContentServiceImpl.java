package com.china.myshop.web.admin.service.impl;

import com.china.myshop.commons.dto.BaseResult;
import com.china.myshop.commons.dto.PageInfo;
import com.china.myshop.commons.validator.BeanValidator;
import com.china.myshop.domain.TbContent;
import com.china.myshop.web.admin.dao.ContentDao;
import com.china.myshop.web.admin.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ContentServiceImpl
 * @Description:
 * @author: china wu
 * @date: 2019\9\21 0021 23:26
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentDao contentDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public BaseResult save(TbContent content) {
        String msg = BeanValidator.validator(content);

        if (msg != null) {
            return BaseResult.fail(msg);
        } else {
            //重新设置当前的更新时间
            content.setUpdateTime(new Date());
            //id为空表示新增
            if (content.getId() == null) {
                //新增操作要设置当前的创建时间
                content.setCreateTime(new Date());
                contentDao.insert(content);
            }
            //否则为编辑
            else {
                TbContent tbContent = contentDao.selectByPrimaryKey(content.getId());
                content.setCreateTime(tbContent.getCreateTime());
                contentDao.update(content);
            }
            return BaseResult.success("保存数据成功");
        }
    }

    @Override
    public List<TbContent> list() {
        List<TbContent> users = contentDao.selectAll();
        return users;
    }

    @Override
    public TbContent getById(int id) {
        return contentDao.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteMulti(String[] ids) {
        contentDao.deleteByIds(ids);
    }

    @Override
    public PageInfo<TbContent> page(int draw, int start, int length, TbContent content) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("content", content);

        List<TbContent> contents = contentDao.selectByPage(params);

        int count = contentDao.selectCount(content);

        PageInfo<TbContent> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(contents);

        return pageInfo;
    }

    @Override
    public int count(TbContent content) {
        return contentDao.selectCount(content);
    }

}
