package com.cn.wanxi.servlet.back.about;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.service.IAboutService;
import com.cn.wanxi.service.impl.AboutServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/aboutList")
public class AboutListServlet extends HttpServlet {

    private IAboutService iAboutService = new AboutServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultDto resultDto = iAboutService.getAboutList();

        String json = JSON.toJSONString(resultDto);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
