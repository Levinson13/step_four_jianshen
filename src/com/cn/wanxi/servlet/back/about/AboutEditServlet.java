package com.cn.wanxi.servlet.back.about;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.model.AboutModel;
import com.cn.wanxi.service.IAboutService;
import com.cn.wanxi.service.impl.AboutServiceImpl;
import com.cn.wanxi.util.Upload;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editAbout")
public class AboutEditServlet extends HttpServlet {

    private IAboutService iAboutService = new AboutServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Upload upload = new Upload();
        String string = upload.fileImg(req);
        AboutModel aboutModel = new AboutModel();
        String[] aa = string.split("@@");
        aboutModel.setContent(aa[0]);
        aboutModel.setImg("undefined".equals(aa[1]) ? null : aa[1]);
        aboutModel.setId(Integer.parseInt(aa[2]));

        int num = iAboutService.update(aboutModel);

        String json = JSON.toJSONString(num);
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
