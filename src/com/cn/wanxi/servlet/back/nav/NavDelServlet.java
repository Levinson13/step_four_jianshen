package com.cn.wanxi.servlet.back.nav;

import com.cn.wanxi.service.INavService;
import com.cn.wanxi.service.impl.NavServletImpl;
import com.mysql.cj.xdevapi.JsonArray;
import net.sf.json.JSON;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/navDel")
public class NavDelServlet extends HttpServlet {

    private INavService iNavService = new NavServletImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Integer id = Integer.parseInt(req.getParameter("id"));

//        req.setAttribute("navModelList",iNavService.getNavList());

        int num = iNavService.delete(id);
//        req.getRequestDispatcher("/back/navList.jsp").forward(req,resp);

        JSONArray jsonArray = JSONArray.fromObject(num);

        resp.getWriter().println(jsonArray);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
