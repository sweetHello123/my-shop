package com.china.myshop.domain;

import com.china.myshop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: TbContentCategory
 * @Description: 类目实体类
 * @author: china wu
 * @date: 2019\9\19 0019 23:01
 */
@Data
public class TbContentCategory extends BaseEntity {

    private Integer id;

    /**
     * 父类目id
     */
    private Integer parentId;

    /**
     * 类目名称
     */
    @Length(min = 1, max = 20, message = "类目名称必须介于1-20之间")
    private String name;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 排列序号
     */
    @NotNull(message = "排列序号不能为空")
    private Integer sortOrder;

    /**
     * 是否为父类目
     */
    private Boolean isParent;

    /**
     * 自关联对象
     */
    private TbContentCategory parentCategory;
}