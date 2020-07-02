package com.cn.wanxi.servlet;

import com.cn.wanxi.dto.AboutDto;
import com.cn.wanxi.service.IAboutService;
import com.cn.wanxi.service.impl.AboutServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/about")
public class AboutServlet extends HttpServlet {

    private IAboutService iAboutService = new AboutServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AboutDto aboutDto = iAboutService.getAboutDto();
        req.setAttribute("navModelList",aboutDto.getNavModelList());
        req.setAttribute("aboutDto",aboutDto);
        req.getRequestDispatcher("/jsp/about.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
