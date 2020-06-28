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

@WebServlet("/navEdit")
public class NavEditServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        INavService iNavService = new NavServletImpl();
        String idString = req.getParameter("id");

        Integer id = idString == null ? 0 : Integer.parseInt(idString);

        String href = req.getParameter("href");

        String title = req.getParameter("title");

        String status = req.getParameter("status");

        NavModel navModel = new NavModel();
        if (status.equals("启用")) {
            navModel.setStatus(1);
        }else {
            navModel.setStatus(0);
        }
        navModel.setHref(href);
        navModel.setTitle(title);
        navModel.setId(id);

        int num = iNavService.update(navModel);

        JSONArray jsonArray = JSONArray.fromObject(num);
        resp.getWriter().println(jsonArray);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
