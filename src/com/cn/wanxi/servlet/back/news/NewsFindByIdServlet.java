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

@WebServlet("/newsFindById")
public class NewsFindByIdServlet extends HttpServlet {

    private INewsService iNewsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

        NewsModel newsModel = iNewsService.getOneNews(id);

        String json = JSON.toJSONString(newsModel);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
