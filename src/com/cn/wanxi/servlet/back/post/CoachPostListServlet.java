package com.cn.wanxi.servlet.back.post;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.model.CoachPostModel;
import com.cn.wanxi.service.ICoachPostService;
import com.cn.wanxi.service.ICoachService;
import com.cn.wanxi.service.impl.CoachPostServiceImpl;
import com.cn.wanxi.service.impl.CoachServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/coachPostList")
public class CoachPostListServlet extends HttpServlet {

    private ICoachPostService iCoachPostService = new CoachPostServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CoachPostModel> coachPostModelList = iCoachPostService.findAll();

        String json = JSON.toJSONString(coachPostModelList);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
