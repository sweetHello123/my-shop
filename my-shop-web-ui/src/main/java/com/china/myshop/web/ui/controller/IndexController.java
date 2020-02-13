package com.china.myshop.web.ui.controller;

import com.china.myshop.web.ui.api.ContentsApi;
import com.china.myshop.web.ui.dto.Content;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName: IndexController
 * @Description:
 * @author: china wu
 * @date: 2019\10\12 0012 13:08
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        requestPPT(model);
        return "index";
    }

    /**
     * 请求轮播图
     */
    private List<Content> requestPPT(Model model) {
        List<Content> contents = ContentsApi.PPT();
        model.addAttribute("ppt", contents);
        return contents;
    }
}
