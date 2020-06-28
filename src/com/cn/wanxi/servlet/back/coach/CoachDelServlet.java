package com.cn.wanxi.servlet.back.coach;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.service.ICoachService;
import com.cn.wanxi.service.impl.CoachServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delCoach")
public class CoachDelServlet extends HttpServlet {

    private ICoachService iCoachService = new CoachServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringId = req.getParameter("id");
        Integer id = stringId == null ? 0 : Integer.parseInt(stringId);

        int num = iCoachService.delete(id);

        String json = JSON.toJSONString(num);
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
