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
import java.util.List;

@WebServlet("/productTypeList")
public class ProductTypeListServlet extends HttpServlet {

    private IProductTypeService iProductTypeService = new ProductTypeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductTypeModel> productTypeModelList = iProductTypeService.findAll();

        String json = JSON.toJSONString(productTypeModelList);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
