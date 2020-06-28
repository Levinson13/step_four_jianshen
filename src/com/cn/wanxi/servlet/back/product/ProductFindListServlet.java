package com.cn.wanxi.servlet.back.product;

import com.alibaba.fastjson.JSON;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ProductFindDto;
import com.cn.wanxi.dto.ResultDto;
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

@WebServlet("/findProductList")
public class ProductFindListServlet extends HttpServlet {

    private IProductService iProductService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String type = req.getParameter("type");
        Double price = req.getParameter("price") == null || "".equals(req.getParameter("price"))? 0 : Double.parseDouble(req.getParameter("price"));

        Integer pageSize = "".equals(req.getParameter("pageSize")) ? 10 : Integer.parseInt(req.getParameter("pageSize"));
        Integer pageNum = "".equals(req.getParameter("pageNum")) ? 1 : Integer.parseInt(req.getParameter("pageNum"));

        ProductFindDto productFindDto = new ProductFindDto();
        productFindDto.setName(name);
        productFindDto.setPrice(price);
        if ("0".equals(type)) {
            productFindDto.setType(null);
        }else {
            productFindDto.setType(Integer.parseInt(type));
        }

        PageDto pageDto = new PageDto();
        pageDto.setPageSize(pageSize);
        pageDto.setPageNum(pageNum);

        ResultDto resultDto = iProductService.findAllProductListByCondition(productFindDto, pageDto);

        String json = JSON.toJSONString(resultDto);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
