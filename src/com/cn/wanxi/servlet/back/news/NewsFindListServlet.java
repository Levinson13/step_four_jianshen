package com.cn.wanxi.servlet.back.news;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.dto.NewsFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.service.INewsService;
import com.cn.wanxi.service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findNewsList")
public class NewsFindListServlet extends HttpServlet {

    private INewsService iNewsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String type = req.getParameter("type");

        Integer pageSize = "".equals(req.getParameter("pageSize")) ? 10 : Integer.parseInt(req.getParameter("pageSize"));
        Integer pageNum = "".equals(req.getParameter("pageNum")) ? 1 : Integer.parseInt(req.getParameter("pageNum"));

        NewsFindDto newsFindDto = new NewsFindDto();
        newsFindDto.setTitle(title);
        newsFindDto.setContent(content);
        if ("0".equals(type)) {
            newsFindDto.setType(null);
        }else {
            newsFindDto.setType(Integer.parseInt(type));
        }

        PageDto pageDto = new PageDto();
        pageDto.setPageNum(pageNum);
        pageDto.setPageSize(pageSize);

        ResultDto resultDto = iNewsService.findCoachListByCondition(newsFindDto,pageDto);

        String json = JSON.toJSONString(resultDto);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
