package com.cn.wanxi.servlet.back.coach;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.service.ICoachService;
import com.cn.wanxi.service.impl.CoachServiceImpl;
import com.cn.wanxi.util.Upload;

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
//        String name = req.getParameter("name");
//        Integer post = Integer.parseInt(req.getParameter("post"));
//        String img = req.getParameter("img");
//        Integer id = Integer.parseInt(req.getParameter("id"));

        Upload upload = new Upload();
        String string = upload.fileImg(req);
        String[] aa = string.split("@@");

        CoachModel coachModel = new CoachModel();
        coachModel.setId(Integer.parseInt(aa[0]));
        coachModel.setCoachName(aa[1]);
        coachModel.setCoachPost(Integer.parseInt(aa[2]));
        coachModel.setCoachImg("undefined".equals(aa[3]) ? null : aa[3]);


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
