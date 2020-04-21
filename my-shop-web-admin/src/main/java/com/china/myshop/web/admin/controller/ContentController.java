package com.china.myshop.web.admin.controller;

import com.china.myshop.commons.dto.BaseResult;
import com.china.myshop.commons.dto.PageInfo;
import com.china.myshop.domain.TbContent;
import com.china.myshop.web.admin.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: ContentController
 * @Description: 内容管理控制器
 * @author: china wu
 * @date: 2019\9\22 0022 0:37
 */
@Controller
@RequestMapping("content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @RequestMapping("list")
    public String list() {
        return "contentList";
    }

    /**
     * 在所有请求方法前调用
     *
     * @param id
     * @return
     */
    @ModelAttribute("content")
    public TbContent getById(Integer id) {
        //id不为空,从数据库获取数据
        if (id != null) {
            return contentService.getById(id);
        }
        TbContent content = new TbContent();
        return content;
    }

    @RequestMapping("form")
    public String form() {
        return "contentForm";
    }

    /**
     * 新增/编辑-保存数据
     *
     * @param content
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save", method = {RequestMethod.POST})
    public String save(TbContent content, Model model, RedirectAttributes redirectAttributes) {
        if (content.getId() != null) {
            System.out.println(content.getContentCategory().getId());
            System.out.println(content.getContentCategory().getName());
        }

        BaseResult result = contentService.save(content);
        if (result.getStatusCode() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute("result", result);
            return "redirect:/content/list";
        } else {
            model.addAttribute("result", result);
            return "contentForm";
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids, Model model) {
        BaseResult result = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            contentService.deleteMulti(idArray);

            result = BaseResult.success("删除成功!");
            model.addAttribute("result", result);
        } else {
            result = BaseResult.fail("删除失败!");
        }
        return result;
    }

    /**
     * 分页处理
     *
     * @param request
     * @param content
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent content) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 1 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        //封装dataTables需要的结果
        PageInfo<TbContent> pageInfo = contentService.page(draw, start, length, content);
        return pageInfo;
    }

    @RequestMapping(value = "view")
    public String view(TbContent content) {
        return "";
    }

}
