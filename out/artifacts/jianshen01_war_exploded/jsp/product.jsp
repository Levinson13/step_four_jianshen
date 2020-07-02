<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/3
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>产品展示</title>
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/product.css">
</head>
<body>
<jsp:include page="top.jsp"/>
<!--    小导航栏-->
<div class="dh">
    <div>
        <span><img src="../img/p7up.png" height="19" width="15"/></span>
        <span>网站首页 > ></span>
        <span>产品中心</span>
    </div>
    <hr/>
</div>
<!--产品-->
<div class="product">
    <div align="center">
        <c:forEach items="${productDto.productTypeModelList}" var="type">
            <div>${type.type}</div>
        </c:forEach>
    </div>
    <div class="images">
        <c:forEach items="${productDto.productModelList}" var="product">
            <div class="floatLeft" align="center">
                <div><img src="${product.productImg}" height="240" width="240"/></div>
                <div>${product.productName}</div>
                <div>
                    <span>价格</span>
                    <span>${product.productPrice}</span>
                </div>
            </div>
        </c:forEach>
    </div>
    <!--    分页-->
    <div class="page">
        <div align="center">
            <span><</span>
            <span>1</span>
            <span>2</span>
            <span>></span>
        </div>
    </div>
</div>
<jsp:include page="foot.jsp"/>
</body>
</html>
