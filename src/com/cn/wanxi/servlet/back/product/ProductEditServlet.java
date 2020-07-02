package com.cn.wanxi.servlet.back.product;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.model.ProductModel;
import com.cn.wanxi.service.IProductService;
import com.cn.wanxi.service.impl.ProductServiceImpl;
import com.cn.wanxi.util.Upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productEdit")
public class ProductEditServlet extends HttpServlet {

    private IProductService iProductService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String type = req.getParameter("type");
//        String img = req.getParameter("img");
//        Double price = Double.parseDouble(req.getParameter("price"));
//        Integer id = Integer.parseInt(req.getParameter("id"));

        Upload upload = new Upload();
        String string = upload.fileImg(req);
        String[] aa = string.split("@@");

        ProductModel productModel = new ProductModel();
        productModel.setId(Integer.parseInt(aa[0]));
        productModel.setProductName(aa[1]);
        productModel.setProductType(Integer.parseInt(aa[2]));
        productModel.setProductPrice(Double.parseDouble(aa[3]));
        productModel.setProductImg("undefined".equals(aa[4]) ? null : aa[4]);

        int num = iProductService.update(productModel);

        String json = JSON.toJSONString(num);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
