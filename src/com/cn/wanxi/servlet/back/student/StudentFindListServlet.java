package com.cn.wanxi.servlet.back.student;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.dto.StudentFindDto;
import com.cn.wanxi.model.StudentModel;
import com.cn.wanxi.service.IStudentService;
import com.cn.wanxi.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findStudentList")
public class StudentFindListServlet extends HttpServlet {

    private IStudentService iStudentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Integer sex = Integer.parseInt(req.getParameter("sex"));
        Integer startAge = "".equals(req.getParameter("startAge")) ? 0 : Integer.parseInt(req.getParameter("startAge"));
        Integer endAge = "".equals(req.getParameter("endAge")) ? 99 : Integer.parseInt(req.getParameter("endAge"));

        Integer pageSize = "".equals(req.getParameter("pageSize")) ? 10 : Integer.parseInt(req.getParameter("pageSize"));
        Integer pageNum = "".equals(req.getParameter("pageNum")) ? 1 : Integer.parseInt(req.getParameter("pageNum"));

        StudentFindDto studentFindDto = new StudentFindDto();
        PageDto pageDto = new PageDto();
        studentFindDto.setUsername(username);
        studentFindDto.setPassword(password);
        studentFindDto.setSex(sex);
        studentFindDto.setStartAge(startAge);
        studentFindDto.setEndAge(endAge);

        pageDto.setPageSize(pageSize);
        pageDto.setPageNum(pageNum);

//        List<StudentModel> studentModelList = iStudentService.findStudentListByCondition(studentFindDto,pageDto);

        ResultDto resultDto = iStudentService.findStudentListByCondition(studentFindDto,pageDto);

//        System.out.println(resultDto);

        String json = JSON.toJSONString(resultDto);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
