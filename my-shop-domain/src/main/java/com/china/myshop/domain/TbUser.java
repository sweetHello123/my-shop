package com.china.myshop.domain;

import com.china.myshop.commons.persistence.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

/**
 * @ClassName: TbUser
 * @Description: 用户实体类
 * @author: china wu
 * @date: 2019\9\19 0019 23:01
 */
@Data
public class TbUser extends BaseEntity {
    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 手机号
     */
    private String phone;

}