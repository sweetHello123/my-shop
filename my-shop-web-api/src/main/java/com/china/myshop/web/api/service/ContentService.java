package com.china.myshop.web.api.service;

import com.china.myshop.domain.TbContent;

import java.util.List;

/**
 * @description
 * @author Administrator
 */
public interface ContentService {

    /**
     * 根据类目id查询内容列表
     * @param categoryId
     * @return
     */
    List<TbContent> selectByCategoryId(Integer categoryId);
}
