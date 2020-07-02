package com.cn.wanxi.servlet.back.post;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.model.CoachPostModel;
import com.cn.wanxi.model.NewsTypeModel;
import com.cn.wanxi.service.ICoachPostService;
import com.cn.wanxi.service.INewsTypeService;
import com.cn.wanxi.service.impl.CoachPostServiceImpl;
import com.cn.wanxi.service.impl.NewsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCoachPost")
public class CoachPostAddServlet extends HttpServlet {

    private ICoachPostService iCoachPostService = new CoachPostServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String post = req.getParameter("post");
        String status = req.getParameter("status");

        CoachPostModel coachPostModel = new CoachPostModel();
        coachPostModel.setPost(post);
        coachPostModel.setStatus(Integer.parseInt(status));

        int num = iCoachPostService.add(coachPostModel);

        String json = JSON.toJSONString(num);
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
