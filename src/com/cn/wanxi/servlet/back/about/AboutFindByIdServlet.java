package com.cn.wanxi.servlet.back.about;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.model.AboutModel;
import com.cn.wanxi.service.IAboutService;
import com.cn.wanxi.service.impl.AboutServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/aboutFindById")
public class AboutFindByIdServlet extends HttpServlet {

    private IAboutService iAboutService = new AboutServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

        AboutModel aboutModel = iAboutService.getOneAboutModel(id);

        String json = JSON.toJSONString(aboutModel);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
