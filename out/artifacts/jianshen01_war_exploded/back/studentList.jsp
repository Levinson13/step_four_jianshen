<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/17
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/js/jquery-3.5.1.js"></script>
<script src="/js/student.js"></script>
<script src="/js/page.js"></script>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<div>姓名：<input type="text" id="username" name="username">
密码：<input type="text" id="password" name="password">
    <div>性别：<select id="sex">
        <option value="0">全部</option>
        <option value="1">男</option>
        <option value="2">女</option>
    </select>
年龄：<input type="text" id="start-age" name="start-age">至<input type="text" id="end-age" name="end-age"></div>
<input type="button" id="find" name="find" onclick="find()" value="查询"/>
</div>
<table class="table table-striped">
    <thead>
    <tr>
        <td>id</td>
        <td>学员名称</td>
        <td>学员密码</td>
        <td>学员电话</td>
        <td>学员邮箱</td>
        <td>学员内容</td>
        <td>学员图片</td>
        <td>学员性别</td>
        <td>学员年龄</td>
        <td>创建时间</td>
    </tr>
    </thead>
    <tbody id="container">

    </tbody>
</table>
<div>
    每一页显示<input type="text" id="pageSize">条
    总页数<span id="pageCount"></span>页
    跳转到<input type="text" id="pageNum"/>页
    <a href="javascript:paging('go')" >【GO】</a>
    <a href="javascript:paging('first')" >首页</a>
    <a href="javascript:paging('previous')" >上一页</a>
    <a href="javascript:paging('next')" >下一页</a>
    <a href="javascript:paging('end')" >尾页</a>
<%--    总条数<span id="pageCount"></span>--%>
</div>
</body>
</html>
