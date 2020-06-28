package com.cn.wanxi.servlet.back.nav;

import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.service.INavService;
import com.cn.wanxi.service.impl.NavServletImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/navFindById")
public class NavFindByIdServlet extends HttpServlet {

    private INavService iNavService = new NavServletImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");

        Integer id = idString == null ? 0 : Integer.parseInt(idString);

        NavModel navModel = iNavService.getOneNavModel(id);

        resp.setContentType("text/html;charset=utf-8");

        JSONArray jsonArray = JSONArray.fromObject(navModel);
        resp.getWriter().println(jsonArray);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
