package com.china.myshop.commons.utils;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: china wu
 * @Description: 邮件发送工具类
 * @Date: 2020/1/6 15:37
 */
public class SendEmailUtils {

    @Autowired
    private Email email;

    public void send(String subject,String msg,String... to) throws EmailException {
        email.setSubject(subject);
        email.setMsg(msg);
        email.addTo(to);
        email.send();
    }
}
