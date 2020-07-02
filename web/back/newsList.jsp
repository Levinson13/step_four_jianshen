<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/18
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/js/jquery-3.5.1.js"></script>
<script src="/js/news.js"></script>
<script src="/js/page.js"></script>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<div>新闻标题：<input type="text" id="title" name="title"></div>
<div>新闻类别：
    <select id="type" name = "type">
<%--        <option value="0">全部</option>--%>
<%--        <option value="1">公司信息</option>--%>
<%--        <option value="2">行业动态</option>--%>
<%--        <option value="3">媒体报道</option>--%>
    </select>
</div>
<div>
    内容：<textarea id="content" name="content"></textarea>
</div>
<input type="button" id="find" name="find" onclick="find()" value="查询"/>
<table class="table table-striped">
    <thead>
    <tr>
        <td>id</td>
        <td>新闻标题</td>
        <td>新闻类型</td>
        <td>新闻图片</td>
        <td>内容</td>
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
