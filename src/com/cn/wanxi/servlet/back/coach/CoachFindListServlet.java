package com.cn.wanxi.servlet.back.coach;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.dto.CoachFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.service.ICoachService;
import com.cn.wanxi.service.impl.CoachServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findCoachList")
public class CoachFindListServlet extends HttpServlet {

    private ICoachService iCoachService = new CoachServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String coachname = req.getParameter("coachname");
        String post = req.getParameter("post");

        Integer pageSize = "".equals(req.getParameter("pageSize")) ? 10 : Integer.parseInt(req.getParameter("pageSize"));
        Integer pageNum = "".equals(req.getParameter("pageNum")) ? 1 : Integer.parseInt(req.getParameter("pageNum"));

        CoachFindDto coachFindDto = new CoachFindDto();
        coachFindDto.setCoachName(coachname);

        if ("0".equals(post))  coachFindDto.setPost("");
        else  coachFindDto.setPost(post);

        PageDto pageDto = new PageDto();

        pageDto.setPageSize(pageSize);
        pageDto.setPageNum(pageNum);

        ResultDto resultDto = iCoachService.findCoachListByCondition(coachFindDto, pageDto);

        String json = JSON.toJSONString(resultDto);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
