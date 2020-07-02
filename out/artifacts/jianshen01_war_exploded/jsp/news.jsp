<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/3
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>新闻资讯</title>
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/news.css">
</head>
<body>
<jsp:include page="top.jsp"/>
<!--    小导航栏-->
<div class="dh">
    <div>
        <span><img src="../img/p7up.png" height="19" width="15"/></span>
        <span>网站首页 > ></span>
        <span>新闻资讯</span>
    </div>
    <hr/>
</div>
<!--中间部分：具体的新闻资讯-->
<div class="news-middle">
    <!--    新闻资讯下的标题-->
    <div align="center">
        <c:forEach items="${newsDto.newsTypeModelList}" var="type">
            <div>${type.type}</div>
        </c:forEach>>
    </div>
    <!--    具体标题的新闻-->
    <div class="news" >
        <c:forEach items="${newsDto.newsModelList}" var="news">
            <div>
                <div class="floatLeft" align="center">
                    <fmt:parseDate value="${news.createDate}" var="time" pattern="yyyy-MM-dd"/>
                    <div><fmt:formatDate value="${time}" pattern="dd"/></div>
                    <div><fmt:formatDate value="${time}" pattern="yyyy-MM"/></div>
                </div>
                <div class="floatLeft">
                        <div>${news.newsTitle}</div>
                        <div>${news.newsContent}</div>
                </div>
            </div>
        </c:forEach>
    </div>
    <!--    分页-->
    <div class="page">
        <div align="center">
            <span><</span>
            <span>1</span>
            <span>></span>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>
