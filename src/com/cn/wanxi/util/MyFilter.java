package com.cn.wanxi.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("UTF-8");

        String path = request.getServletPath();

        List<String> list = new ArrayList<>();

        list.add("/login");
        list.add("/register");
        list.add("/home");
        list.add("/about");
        list.add("/callus");
        list.add("/news");
        list.add("/product");
        list.add("/coach");
        list.add("/top");
        list.add("/foot");
        list.add("/code");

        boolean go = false;
        for (String p : list) {
            if (p.equals(path)) {
                go = true;
                break;
            }
        }
        String files[] = {"/jsp/","/js/","/css/","/img/","/loadImg/"};
        for (String f : files) {
            if (path.startsWith(f)) {
                go = true;
                break;
            }
        }

        if (go) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String username = (String) request.getSession().getAttribute("username");
            if (username == null) {
                response.sendRedirect("/jsp/login.jsp");
            } else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
