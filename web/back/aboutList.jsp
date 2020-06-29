<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/28
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/js/jquery-3.5.1.js"></script>
<script src="/js/about.js"></script>
<script src="/js/page.js"></script>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<div>信息内容：<input type="text" id="aboutcontent" name="aboutcontent"></div>
<input type="button" id="find" name="find" onclick="find()" value="查询"/>
</div>
<table class="table table-striped">
    <thead>
    <tr>
        <td>id</td>
        <td>信息内容</td>
        <td>信息图片</td>
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
