package com.china.myshop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author china wu
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String email;

    private String username;

    private String password;

    private String phone;

    private String vfCode;

}
