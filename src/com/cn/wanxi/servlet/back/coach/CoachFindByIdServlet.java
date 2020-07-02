package com.cn.wanxi.servlet.back.coach;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.dto.CoachBackDto;
import com.cn.wanxi.dto.CoachDto;
import com.cn.wanxi.model.CoachModel;
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

@WebServlet("/coachFindById")
public class CoachFindByIdServlet extends HttpServlet {

    private ICoachService iCoachService = new CoachServiceImpl();

    private ICoachPostService iCoachPostService = new CoachPostServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringId = req.getParameter("id");
        Integer id = stringId == null ? 0 : Integer.parseInt(stringId);

        CoachModel coachModel = iCoachService.getOneCoachModel(id);
        List<CoachPostModel> coachPostModelList = iCoachPostService.findAll();

        CoachBackDto coachBackDto = new CoachBackDto();
        coachBackDto.setCoachPostModelList(coachPostModelList);
        coachBackDto.setCoachModel(coachModel);

        String json = JSON.toJSONString(coachBackDto);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
