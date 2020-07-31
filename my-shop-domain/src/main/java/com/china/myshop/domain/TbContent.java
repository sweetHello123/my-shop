package com.china.myshop.domain;

import com.china.myshop.commons.persistence.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: TbContent
 * @Description: 内容实体类
 * @author: china wu
 * @date: 2019\9\21 0021 21:42
 */
@Data
public class TbContent extends BaseEntity {

    private Integer id;

    /**
     * 主标题
     */
    @NotNull(message = "标题不能为空")
    private String title;

    /**
     * 子标题
     */
    @NotNull(message = "子标题不能为空")
    private String subTitle;

    /**
     * 描述
     */
    private String description;

    /**
     * 路径
     */
    private String url;

    /**
     * 图片
     */
    private String picture;

    /**
     * 详情
     */
    private String info;

    /**
     * 关联类目对象
     */
    @NotNull(message = "类目不能为空")
    private TbContentCategory contentCategory;
}