package com.china.myshop.web.admin.controller;

import com.china.myshop.commons.dto.BaseResult;
import com.china.myshop.commons.dto.PageInfo;
import com.china.myshop.domain.TbUser;
import com.china.myshop.web.admin.service.UserService;
import org.apache.commons.codec.binary.Base64;
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
 * @ClassName: UserController
 * @Description: 用户管理控制器
 * @author: china wu
 * @date: 2019\9\9 0009 16:30
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到用户列表
     *
     * @return
     */
    @RequestMapping("list")
    public String list() {
        return "userList";
    }

    /**
     * 获取对象(在所有请求方法前调用)
     *
     * @param id
     * @return
     */
    @ModelAttribute("user")
    public TbUser getById(Integer id) {
        //id不为空,从数据库获取数据
        if (id != null) {
            TbUser user = userService.getById(id);

            //Base64密码解密
            byte[] bytes = Base64.decodeBase64(user.getPassword().getBytes());
            user.setPassword(new String(bytes));

            return user;
        }
        TbUser user = new TbUser();
        return user;
    }

    @RequestMapping("form")
    public String form() {
        return "userForm";
    }

    /**
     * 新增/编辑-保存数据
     *
     * @param user
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser user, Model model, RedirectAttributes redirectAttributes) {
        BaseResult result = userService.save(user);
        if (result.getStatusCode() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute("result", result);
            return "redirect:/user/list";
        } else {
            model.addAttribute("result", result);
            return "userForm";
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
            userService.deleteMulti(idArray);

            result = BaseResult.success("删除成功");
            model.addAttribute("result", result);
        } else {
            result = BaseResult.fail("删除失败");
        }
        return result;
    }

    /**
     * 分页处理
     *
     * @param request
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbUser> page(HttpServletRequest request, TbUser user) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 1 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        //封装dataTables需要的结果
        PageInfo<TbUser> pageInfo = userService.page(draw, start, length, user);
        return pageInfo;
    }

    /**
     * 详情查询
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "view")
    public String view(TbUser user) {
        return "userView";
    }

}
