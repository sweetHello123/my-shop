package com.china.myshop.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName: UploadController
 * @Description: 文件上传控制器
 * @author: china wu
 * @date: 2019\9\25 0025 15:03
 */
@Controller
public class UploadController {
    /**
     * 定义上传的目录
     */
    private static final String UPLOAD_DIRECTION = "/static/upload/";

    /**
     * @param dzFile     dropzone上传的文件
     * @param wangEdFile 富文本编辑器上传的文件
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dzFile, MultipartFile wangEdFile, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();

        MultipartFile myFile = dzFile == null ? wangEdFile : dzFile;

        //获取上传文件名
        String fileName = myFile.getOriginalFilename();

        //获取文件名后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        //设置文件存放路径
        String fileSavePath = request.getSession().getServletContext().getRealPath(UPLOAD_DIRECTION);

        //传入路径创建文件对象
        File uploadFile = new File(fileSavePath);
        if (!uploadFile.exists()) {
            uploadFile.mkdir();
        }
        uploadFile = new File(fileSavePath, UUID.randomUUID() + fileSuffix);
        try {
            myFile.transferTo(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取服务器路径
        String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

        //dropzone上传
        if (dzFile != null) {
            result.put("fileName", UPLOAD_DIRECTION + uploadFile.getName());
        }

        if (wangEdFile != null) {
            /**
             * wangEditor要显示上传文件成功需返回如下json数据
             {
             // errno 即错误代码，0 表示没有错误。
             // 如果有错误，errno != 0，可通过下文中的监听函数 fail 拿到该错误码进行自定义处理
             // data 是一个数组，返回若干图片的线上地址
             "errno": 0,
             "data": [
             "图片1地址",
             "图片2地址",
             "……"
             ]
             }
             */
            result.put("errno", 0);
            result.put("data", new String[]{serverPath + UPLOAD_DIRECTION + uploadFile.getName()});
        }
        return result;
    }

}
