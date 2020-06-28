package com.cn.wanxi.servlet.back.coach;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.service.ICoachService;
import com.cn.wanxi.service.impl.CoachServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/coachList")
public class CoachListServlet extends HttpServlet {

    private ICoachService iCoachService = new CoachServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ResultDto resultDto = iCoachService.getCoachList();
//        List<CoachModel> coachModelList = iCoachService.getCoachList();

        resp.setContentType("text/html;charset=utf-8");
        String json = JSON.toJSONString(resultDto);
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
