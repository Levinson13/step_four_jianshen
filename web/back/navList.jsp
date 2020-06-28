<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/12
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/js/jquery-3.5.1.js"></script>
<script src="/js/nav.js"></script>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
    <table class="table table-striped">
        <thead>
        <tr>
            <td>id</td>
            <td>链接</td>
            <td>标题</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody id="container">
<%--        <c:forEach items="${navModelList}" var="nav">--%>
<%--            <tr>--%>
<%--                <td id="id">${nav.id}</td>--%>
<%--                <td>${nav.href}</td>--%>
<%--                <td>${nav.title}</td>--%>
<%--                <td><a href="/navEdit?id=${nav.id}">编辑</a></td>--%>
<%--                <td><input type="button" onclick="del()" value="删除"></td>--%>
<%--&lt;%&ndash;                <td><a href="/navDel?id=${nav.id}" >删除</a></td>&ndash;%&gt;--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
        </tbody>
    </table>
</body>
</html>
