package com.cn.wanxi.servlet.back.news;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.service.INewsService;
import com.cn.wanxi.service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editNews")
public class NewsEditServlet extends HttpServlet {

    private INewsService iNewsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String type = req.getParameter("type");
        String content = req.getParameter("content");

        NewsModel newsModel = new NewsModel();
        newsModel.setId(id);
        newsModel.setNewsTitle(title);
        newsModel.setNewsType(Integer.parseInt(type));
        newsModel.setNewsContent(content);

        int num = iNewsService.update(newsModel);

        String json = JSON.toJSONString(num);
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}