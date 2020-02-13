package com.china.myshop.web.api.service.impl;

import com.china.myshop.domain.TbContent;
import com.china.myshop.domain.TbContentCategory;
import com.china.myshop.web.api.dao.ContentDao;
import com.china.myshop.web.api.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: ContentServiceImpl
 * @Description:
 * @author: china wu
 * @date: 2019\10\11 0011 16:18
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentDao dao;


    @Override
    public List<TbContent> selectByCategoryId(Integer categoryId) {
        TbContentCategory contentCategory = new TbContentCategory();
        contentCategory.setId(categoryId);

        TbContent content = new TbContent();
        content.setContentCategory(contentCategory);

        return dao.selectByCategoryId(content);
    }
}
