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
import java.util.List;

@WebServlet("/navList")
public class NavListServlet extends HttpServlet {

    private INavService iNavService = new NavServletImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NavModel> navModelList = iNavService.getNavList();
        resp.setContentType("text/html;charset=utf-8");
        JSONArray jsonArray = JSONArray.fromObject(navModelList);
        resp.getWriter().println(jsonArray);
    }
}
