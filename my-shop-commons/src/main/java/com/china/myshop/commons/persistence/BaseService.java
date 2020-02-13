package com.china.myshop.commons.persistence;

import com.china.myshop.commons.dto.BaseResult;
import com.china.myshop.commons.dto.PageInfo;

import java.util.List;


/**
 * @author china wu
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 保存信息
     *
     * @param entity
     * @return
     */
    BaseResult save(T entity);

    /**
     * 数据列表
     *
     * @return
     */
    List<T> list();

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    T getById(int id);

    /**
     * 批量删除数据
     *
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页显示
     *
     * @param draw
     * @param start
     * @param length
     * @param entity
     * @return
     */
    PageInfo<T> page(int draw, int start, int length, T entity);

    /**
     * 总记录数
     *
     * @param entity
     * @return
     */
    int count(T entity);

//    /**
//     * 更新信息
//     * @param entity
//     */
//    void update(T entity);
}
