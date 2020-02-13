package com.china.myshop.commons.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: BaseEntity
 * @Description: 实体类的基类
 * @author: china wu
 * @date: 2019\9\18 0018 15:12
 */
@Data
public abstract class BaseEntity implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
