package com.cn.wanxi.servlet.back.product;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.dto.ProductBackDto;
import com.cn.wanxi.dto.ProductDto;
import com.cn.wanxi.model.ProductModel;
import com.cn.wanxi.service.IProductService;
import com.cn.wanxi.service.IProductTypeService;
import com.cn.wanxi.service.impl.ProductServiceImpl;
import com.cn.wanxi.service.impl.ProductTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productFindById")
public class ProductFindByIdServlet extends HttpServlet {

    private IProductService iProductService = new ProductServiceImpl();

    private IProductTypeService iProductTypeService = new ProductTypeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

        ProductModel productModel = iProductService.getOneProductModel(id);

        ProductBackDto productBackDto = new ProductBackDto();
        productBackDto.setProductModel(productModel);
        productBackDto.setProductTypeModelList(iProductTypeService.findAll());

        String json = JSON.toJSONString(productBackDto);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
