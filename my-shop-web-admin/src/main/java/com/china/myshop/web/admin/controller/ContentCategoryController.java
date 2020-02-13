package com.china.myshop.web.admin.controller;

import com.china.myshop.commons.dto.BaseResult;
import com.china.myshop.domain.TbContentCategory;
import com.china.myshop.web.admin.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TbContentCategoryController
 * @Description: 类目管理控制器
 * @author: china wu
 * @date: 2019\9\19 0019 23:15
 */
@Controller
@RequestMapping("contentCategory")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;

    /**
     * 跳转类目树表页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "list")
    public String list(Model model) {
        List<TbContentCategory> sourceList = contentCategoryService.list();
        List<TbContentCategory> targetList = new ArrayList<>();

        sortList(sourceList, targetList, 0);
        model.addAttribute("contentCategories", targetList);
        return "contentCategoryList";
    }

    /**
     * 获取对象(在所有请求方法前调用)
     *
     * @param id
     * @return
     */
    @ModelAttribute("contentCategory")
    public TbContentCategory getById(Integer id) {
        TbContentCategory contentCategory = null;
        if (id != null) {
            contentCategory = contentCategoryService.getById(id);
        } else {
            contentCategory = new TbContentCategory();
        }
        return contentCategory;
    }

    /**
     * 新增/编辑-表单跳转
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "contentCategoryForm";
    }

    @ResponseBody
    @RequestMapping(value = "treeData", method = RequestMethod.GET)
    public List<TbContentCategory> treeData(Integer id) {
        if (id == null) {
            id = 0;
        }
        return contentCategoryService.selectByPid(id);
    }

    /**
     * 树表排序
     *
     * @param sourceList 数据源集合
     * @param targetList 排序后的集合
     * @param parentId   父节点id
     */
    public void sortList(List<TbContentCategory> sourceList, List<TbContentCategory> targetList,
                         Integer parentId) {
        for (TbContentCategory tbContentCategory : sourceList) {
            //判断数据源的数据是否存在父类id与传入的id相同
            if (tbContentCategory.getParentId().equals(parentId)) {
                targetList.add(tbContentCategory);

                //判断当前数据是否有子节点(即它是否是父节点),有就继续追加节点
                if (tbContentCategory.getIsParent()) {
                    for (TbContentCategory contentCategory : sourceList) {
                        //判断源数据中是否存在数据的父类id与当前数据的id相同
                        if (contentCategory.getParentId().equals(tbContentCategory.getId())) {
                            //递归调用
                            sortList(sourceList, targetList, tbContentCategory.getId());
                            //要中断,否则会重复排序追加
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * 新增/编辑-保存数据
     *
     * @param contentCategory
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContentCategory contentCategory, Model model, RedirectAttributes redirectAttributes) {
        BaseResult result = contentCategoryService.save(contentCategory);

        if (result.getStatusCode() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute("result", result);
            return "redirect:/contentCategory/list";
        } else {
            model.addAttribute("result", result);
            return "contentCategoryForm";
        }
    }

//    public String deleteCategorys(String ids) {
//        BaseResult result = null;
//        if (StringUtils.isNotBlank(ids)) {
//            String[] idArray = ids.split(",");
//
//
//            result = BaseResult.success("删除成功!");
//        } else {
//            result = BaseResult.fail("删除失败!");
//        }
//        return result;
//    }
}
