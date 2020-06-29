package com.cn.wanxi.servlet.back.about;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.dto.AboutFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.service.IAboutService;
import com.cn.wanxi.service.impl.AboutServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findAboutList")
public class AboutFindListServlet extends HttpServlet {

    private IAboutService iAboutService = new AboutServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("content");

        Integer pageSize = "".equals(req.getParameter("pageSize")) ? 10 : Integer.parseInt(req.getParameter("pageSize"));
        Integer pageNum = "".equals(req.getParameter("pageNum")) ? 1 : Integer.parseInt(req.getParameter("pageNum"));

        AboutFindDto aboutFindDto = new AboutFindDto();
        aboutFindDto.setContent(content);

        PageDto pageDto = new PageDto();
        pageDto.setPageNum(pageNum);
        pageDto.setPageSize(pageSize);

        ResultDto resultDto = iAboutService.findAboutListByCondition(aboutFindDto, pageDto);

        String json = JSON.toJSONString(resultDto);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
