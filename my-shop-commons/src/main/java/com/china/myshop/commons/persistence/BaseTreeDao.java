package com.china.myshop.commons.persistence;

import java.util.List;

/**
 * 通用的树形dao接口
 *
 * @author china wu
 */
public interface BaseTreeDao<T extends BaseEntity> {

    /**
     * 新增
     *
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 查询所有记录详情
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 通过父类id查询对象
     * @param parentId
     * @return
     */
    List<T> selectByPid(Integer parentId);

}
