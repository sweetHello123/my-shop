package com.china.myshop.web.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: ContentDTO
 * @Description: 内容数据传输对象
 * @author: china wu
 * @date: 2019\10\10 0010 22:29
 */
@Data
public class ContentDTO implements Serializable {

    private Integer id;

    private String title;

    private String subTitle;

    private String description;

    private String url;

    private String picture;

}
