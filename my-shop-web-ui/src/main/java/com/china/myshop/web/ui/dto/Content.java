package com.china.myshop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;


/**
 * @author china wu
 */
@Data
public class Content implements Serializable {

    private Integer id;

    private String title;

    private String subTitle;

    private String description;

    private String url;

    private String picture;

    private String content;

}
