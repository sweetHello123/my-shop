package com.china.myshop.web.api.dao;

import com.china.myshop.domain.TbContent;

import java.util.List;

/**
 * @author china wu
 * @description
 */
public interface ContentDao {

    /**
     * 根据类目id查询内容列表
     *
     * @param content
     * @return
     */
    List<TbContent> selectByCategoryId(TbContent content);
}
