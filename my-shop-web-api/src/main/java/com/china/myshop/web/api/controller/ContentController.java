package com.china.myshop.web.api.controller;

import com.china.myshop.commons.dto.BaseResult;
import com.china.myshop.domain.TbContent;
import com.china.myshop.web.api.dto.ContentDTO;
import com.china.myshop.web.api.service.ContentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ContentController
 * @Description:
 * @author: china wu
 * @date: 2019\10\11 0011 16:38
 */
@RestController
@RequestMapping(value = "/api/content")
public class ContentController {

    @Autowired
    private ContentService service;

    @ModelAttribute
    public TbContent getContent(Integer id) {
        TbContent content = null;
        if (id == null) {
            content = new TbContent();
        }

        return content;
    }

    @RequestMapping("{category_id}")
    public BaseResult findContentByCategoryId(@PathVariable("category_id") Integer categoryId) {
        //定义contentDTO集合
        List<ContentDTO> contentDTOS = null;

        List<TbContent> contents = service.selectByCategoryId(categoryId);

        if (contents != null && contents.size() > 0) {
            contentDTOS = new ArrayList<>();

            for (TbContent content : contents) {
                //创建contentDTO数据传输对象
                ContentDTO contentDTO = new ContentDTO();

                //将集合中的content对象的属性值传输给contentDTO对象
                BeanUtils.copyProperties(content, contentDTO);

                contentDTOS.add(contentDTO);
            }
        }
        return BaseResult.success("成功", contentDTOS);
    }

}
