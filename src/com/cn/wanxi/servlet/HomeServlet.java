package com.cn.wanxi.servlet;

import com.cn.wanxi.dto.HomeDto;
import com.cn.wanxi.service.IHomeService;
import com.cn.wanxi.service.impl.HomeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private IHomeService iHomeService = new HomeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HomeDto homeDto = iHomeService.getHomeDto();
        req.setAttribute("homeDto", homeDto);
        req.getRequestDispatcher("/jsp/home.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
