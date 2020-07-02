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
import java.util.List;

@WebServlet("/newsTypeList")
public class NewsTypeListServlet extends HttpServlet {

    private INewsTypeService iNewsTypeService = new NewsTypeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NewsTypeModel> newsTypeModelList = iNewsTypeService.findAll();

        String json = JSON.toJSONString(newsTypeModelList);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
