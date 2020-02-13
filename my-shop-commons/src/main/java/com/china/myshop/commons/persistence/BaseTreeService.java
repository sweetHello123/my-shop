package com.china.myshop.commons.persistence;

import com.china.myshop.commons.dto.BaseResult;

import java.util.List;

/**
 * 通用的树形service接口
 *
 * @author china wu
 */
public interface BaseTreeService<T extends BaseEntity> {

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
     * 更新信息
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 根据父类id查询所有子节点
     *
     * @param parentId
     * @return
     */
    List<T> selectByPid(Integer parentId);
}
