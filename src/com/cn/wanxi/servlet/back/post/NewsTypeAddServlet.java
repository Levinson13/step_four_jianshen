package com.cn.wanxi.servlet.back.post;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.model.NewsTypeModel;
import com.cn.wanxi.service.INewsTypeService;
import com.cn.wanxi.service.impl.NewsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addNewsType")
public class NewsTypeAddServlet extends HttpServlet {

    private INewsTypeService iNewsTypeService = new NewsTypeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String post = req.getParameter("post");
        String status = req.getParameter("status");

        NewsTypeModel newsTypeModel = new NewsTypeModel();
        newsTypeModel.setType(post);
        newsTypeModel.setStatus(Integer.parseInt(status));

        int num = iNewsTypeService.add(newsTypeModel);

        String json = JSON.toJSONString(num);
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
