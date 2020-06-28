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

@WebServlet("/addProduct")
public class ProductAddServlet extends HttpServlet {

    private IProductService iProductService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Upload upload = new Upload();
        String string = upload.fileImg(req);
        String[] aa = string.split("@@");

//        String name = req.getParameter("name");
//        String type = req.getParameter("type");
//        String img = req.getParameter("img");
//        Double price = Double.parseDouble(req.getParameter("price"));

        ProductModel productModel = new ProductModel();
        productModel.setProductName(aa[0]);
        productModel.setProductType(Integer.parseInt(aa[1]));
        productModel.setProductImg(aa[2]);
        productModel.setProductPrice(Double.parseDouble(aa[3]));
        int num = 0;
        try {
            num = iProductService.add(productModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(num);

        String json = JSON.toJSONString(num);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
