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

@WebServlet("/navAdd")
public class NavAddServlet extends HttpServlet {

    private INavService iNavService = new NavServletImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String href = req.getParameter("href");
        String title = req.getParameter("title");

        NavModel navModel = new NavModel();
        navModel.setHref(href);
        navModel.setTitle(title);

        int num = iNavService.add(navModel);
        resp.getWriter().println(num);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }


}
