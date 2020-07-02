package com.cn.wanxi.servlet;

import com.cn.wanxi.dto.CallUsDto;
import com.cn.wanxi.service.ICallUsService;
import com.cn.wanxi.service.impl.CallUsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/callus")
public class CallusServlet extends HttpServlet{

    private ICallUsService iCallUsService = new CallUsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CallUsDto callUsDto = iCallUsService.getCallUsDto();
        req.setAttribute("navModelList",callUsDto.getNavModelList());
        req.setAttribute("callUsDto",callUsDto);
        req.getRequestDispatcher("/jsp/callus.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
