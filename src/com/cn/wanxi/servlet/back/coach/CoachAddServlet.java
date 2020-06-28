package com.cn.wanxi.servlet.back.coach;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.model.StudentModel;
import com.cn.wanxi.service.ICoachService;
import com.cn.wanxi.service.impl.CoachServiceImpl;
import com.cn.wanxi.util.Upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/addCoach")
public class CoachAddServlet extends HttpServlet {

    private ICoachService iCoachService = new CoachServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Upload upload = new Upload();
        String string = upload.fileImg(req);
        CoachModel coachModel = new CoachModel();
        String[] aa = string.split("@@");
        System.out.println(Arrays.toString(aa));
//        String name = req.getParameter("name");
//        Integer post = Integer.parseInt(req.getParameter("post"));
//        String img = req.getParameter("img");
        System.out.println(Arrays.toString(aa));
        coachModel.setCoachName(aa[0]);
        coachModel.setCoachPost(Integer.parseInt(aa[1]));
        coachModel.setCoachImg(aa[2]);

        int num = iCoachService.add(coachModel);

        String json = JSON.toJSONString(num);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
