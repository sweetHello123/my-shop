package com.china.myshop.web.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author china wu
 * @Description: 登录用户传输对象
 */
@Data
public class UserDTO implements Serializable {
    private Integer id;

    private String email;

    private String username;

    private String password;

    private String phone;
}
