package com.cn.wanxi.servlet.back.news;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.service.INewsService;
import com.cn.wanxi.service.impl.NewsServiceImpl;
import com.cn.wanxi.util.Upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addNews")
public class NewsAddServlet extends HttpServlet {

    private INewsService iNewsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Upload upload = new Upload();
        String string = upload.fileImg(req);
        String[] aa = string.split("@@");

//        String title = req.getParameter("title");
//        String type = req.getParameter("type");
//        String content = req.getParameter("content");

        NewsModel newsModel = new NewsModel();
        newsModel.setNewsTitle(aa[0]);
        newsModel.setNewsType(Integer.parseInt(aa[1]));
        newsModel.setNewsImg(aa[2]);
        newsModel.setNewsContent(aa[3]);

        int num = iNewsService.add(newsModel);
        String json = JSON.toJSONString(num);

        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
