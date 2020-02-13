package com.china.myshop.web.admin.service.impl;

import com.china.myshop.commons.dto.BaseResult;
import com.china.myshop.commons.validator.BeanValidator;
import com.china.myshop.domain.TbContentCategory;
import com.china.myshop.web.admin.dao.ContentCategoryDao;
import com.china.myshop.web.admin.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: TbContentCategoryServiceImpl
 * @Description:
 * @author: china wu
 * @date: 2019\9\19 0019 23:16
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private ContentCategoryDao contentCategoryDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public BaseResult save(TbContentCategory contentCategory) {
        String msg = BeanValidator.validator(contentCategory);
        if (msg != null) {
            return BaseResult.fail(msg);
        } else {
            //获取父级类目
            TbContentCategory parentCategory = contentCategory.getParentCategory();
            //若父级类目不存在，则它为根目录
            if (parentCategory == null || parentCategory.getId() == null) {
                //它的父级id设置为0
                parentCategory.setId(0);
            }

            contentCategory.setUpdateTime(new Date());

            //新增操作
            if (contentCategory.getId() == null) {
                contentCategory.setCreateTime(new Date());
                contentCategory.setIsParent(false);

                TbContentCategory currentCategoryParent = contentCategoryDao.selectByPrimaryKey(parentCategory.getId());
                //判断新增的节点有没有父节点,有则为新增下级类目
                if (currentCategoryParent != null) {
                    //父类目设置isParent为true
                    currentCategoryParent.setIsParent(true);
                    update(currentCategoryParent);
                }
                //否则是新增根目录
                else {
                    //根目录一定是父级类目
                    contentCategory.setIsParent(true);
                }
                contentCategoryDao.insert(contentCategory);
            }
            //修改操作
            else {
                contentCategoryDao.update(contentCategory);
            }
        }
        return BaseResult.success("保存数据成功");
    }

    @Override
    public List<TbContentCategory> list() {
        return contentCategoryDao.selectAll();
    }

    @Override
    public TbContentCategory getById(int id) {
        return contentCategoryDao.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void update(TbContentCategory entity) {
        contentCategoryDao.update(entity);
    }

    @Override
    public List<TbContentCategory> selectByPid(Integer parentId) {
        return contentCategoryDao.selectByPid(parentId);
    }
}
