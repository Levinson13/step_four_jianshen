package com.cn.wanxi.servlet.back.student;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.model.StudentModel;
import com.cn.wanxi.service.IProductService;
import com.cn.wanxi.service.IStudentService;
import com.cn.wanxi.service.impl.ProductServiceImpl;
import com.cn.wanxi.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentList")
public class StudentListServlet extends HttpServlet {

    private IStudentService iStudentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String status = "0";
//        String newStatus = req.getParameter("status");
//        if (newStatus == null) {
//
//        }

        ResultDto resultDto = iStudentService.getStudentList();
        String json = JSON.toJSONString(resultDto);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
