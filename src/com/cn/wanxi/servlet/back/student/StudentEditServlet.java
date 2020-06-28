package com.cn.wanxi.servlet.back.student;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.model.StudentModel;
import com.cn.wanxi.service.IProductService;
import com.cn.wanxi.service.IStudentService;
import com.cn.wanxi.service.impl.ProductServiceImpl;
import com.cn.wanxi.service.impl.StudentServiceImpl;
import com.cn.wanxi.util.Upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/editStudent")
public class StudentEditServlet extends HttpServlet {

    private IStudentService iStudentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Upload upload = new Upload();
        String string = upload.fileImg(req);
        StudentModel studentModel = new StudentModel();
        String[] aa = string.split("@@");
        System.out.println(Arrays.toString(aa));
//        String name = req.getParameter("name");
//        String phone = req.getParameter("phone");
//        String email = req.getParameter("email");
//        String content = req.getParameter("content");
//        String img = req.getParameter("img");
////        String sex = req.getParameter("sex");
//        Integer sex = Integer.parseInt(req.getParameter("sex"));
//        Integer age = Integer.parseInt(req.getParameter("age"));
//        Integer id = Integer.parseInt(req.getParameter("id"));
//        String password = req.getParameter("password");

        studentModel.setId(Integer.parseInt(aa[0]));
        studentModel.setStuName(aa[1]);
        studentModel.setStuPassword(aa[2]);
        studentModel.setStuPhone(aa[3]);
        studentModel.setStuEmail(aa[4]);
        studentModel.setStuContent(aa[5]);
        studentModel.setStuSex(Integer.parseInt(aa[6]));
        studentModel.setStuAge(Integer.parseInt(aa[7]));
        studentModel.setStuImg(aa[8]);

        int num = iStudentService.update(studentModel);

        String json = JSON.toJSONString(num);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
