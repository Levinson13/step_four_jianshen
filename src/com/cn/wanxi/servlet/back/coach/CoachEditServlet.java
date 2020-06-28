package com.cn.wanxi.servlet.back.coach;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.service.ICoachService;
import com.cn.wanxi.service.impl.CoachServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editCoach")
public class CoachEditServlet extends HttpServlet {

    private ICoachService iCoachService = new CoachServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer post = Integer.parseInt(req.getParameter("post"));
        String img = req.getParameter("img");
        Integer id = Integer.parseInt(req.getParameter("id"));


        CoachModel coachModel = new CoachModel();
        coachModel.setCoachName(name);
        coachModel.setCoachPost(post);
        coachModel.setCoachImg(img);
        coachModel.setId(id);

        int num = iCoachService.update(coachModel);

        String json = JSON.toJSONString(num);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
