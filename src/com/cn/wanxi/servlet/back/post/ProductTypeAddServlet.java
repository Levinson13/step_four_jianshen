package com.cn.wanxi.servlet.back.post;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.model.NewsTypeModel;
import com.cn.wanxi.model.ProductTypeModel;
import com.cn.wanxi.service.INewsTypeService;
import com.cn.wanxi.service.IProductTypeService;
import com.cn.wanxi.service.impl.NewsTypeServiceImpl;
import com.cn.wanxi.service.impl.ProductTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addProductType")
public class ProductTypeAddServlet extends HttpServlet {

    private IProductTypeService iProductTypeService = new ProductTypeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String post = req.getParameter("post");
        String status = req.getParameter("status");

        ProductTypeModel productTypeModel = new ProductTypeModel();
        productTypeModel.setType(post);
        productTypeModel.setStatus(Integer.parseInt(status));

        int num = iProductTypeService.add(productTypeModel);

        String json = JSON.toJSONString(num);
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
