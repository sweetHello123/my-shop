package com.china.myshop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * @author china wu
 */
public interface BaseDao<T extends BaseEntity> {

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(String[] ids);

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
     * 分页查询
     *
     * @param params 需要2个参数:start(记录起始位置)/length(每页记录数)
     * @return
     */
    List<T> selectByPage(Map<String, Object> params);

    /**
     * 查询所有记录数
     *
     * @param entity
     * @return
     */
    int selectCount(T entity);
}
