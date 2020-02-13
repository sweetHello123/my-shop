package com.china.myshop.web.ui.api;

import com.china.myshop.commons.utils.HttpClientUtils;
import com.china.myshop.commons.utils.JacksonUtils;
import com.china.myshop.web.ui.dto.User;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2019/12/19 21:25
 */
public class UsersApi {

    public static User login(User user) {
        List<BasicNameValuePair> params = new ArrayList<>();

        params.add(new BasicNameValuePair("username", user.getUsername()));
        params.add(new BasicNameValuePair("password", user.getPassword()));

        String result = HttpClientUtils.doPost(Api.USER_LOGIN, null, params);

        try {
            User pojo = JacksonUtils.json2pojoByTree(result, "data", User.class);
//            System.out.println(pojo);
            return pojo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
