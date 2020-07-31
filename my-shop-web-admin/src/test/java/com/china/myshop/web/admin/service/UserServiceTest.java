package com.china.myshop.web.admin.service;

import com.china.myshop.web.admin.service.impl.UserServiceImpl;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.springframework.util.DigestUtils;

/**
 * @ClassName: UserServiceTest
 * @Description:
 * @author: china wu
 * @date: 2019\9\9 0009 14:03
 */
public class UserServiceTest {

    private UserService userService = new UserServiceImpl();

    /**
     * Md5加密测试
     */
    @Test
    public void md5Test() {
        String password = "admin";
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(md5Password);
    }

    /**
     * Base64加密测试
     */
    @Test
    public void Base64encodeTest() {
        String s = "admin";
        byte[] b = Base64.encodeBase64(s.getBytes(), true);
        String str = new String(b);
        str = str.replaceAll("\r|\n", "");
        System.out.println(str.equals("YWRtaW4="));
    }

    /**
     * Base64解密测试
     */
    @Test
    public void Base64decodeTest() {
        String s = "YWRtaW4=";
        byte[] bytes = Base64.decodeBase64(s.getBytes());
        System.out.println(new String(bytes).equals("admin"));
    }

}
