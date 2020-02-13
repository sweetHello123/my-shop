package com.china.myshop.web.ui.api;

import com.china.myshop.commons.utils.HttpClientUtils;
import com.china.myshop.commons.utils.JacksonUtils;
import com.china.myshop.web.ui.dto.Content;

import java.util.List;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2019/12/19 21:16
 */
public class ContentsApi {

    public static List<Content> PPT() {
        String result = HttpClientUtils.doGet(Api.CONTENT_PPT + "6", null);
//        System.out.println(result);

        try {
            List<Content> contents = JacksonUtils.json2listByTree(result, "data", Content.class);
            return contents;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
