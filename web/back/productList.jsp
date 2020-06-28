<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/17
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>产品列表</title>
</head>
<script src="/js/jquery-3.5.1.js"></script>
<script src="/js/product.js"></script>
<script src="/js/page.js"></script>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    $(function () {
        findAllProduct();
    })
</script>
<body>
<div>产品名称：<input type="text" id="name" name="name"></div>
<div>产品类别：
    <select id="type" name = type>
        <option value="0">全部</option>
        <option value="1">杠铃</option>
        <option value="2">瑜伽</option>
        <option value="3">拳击</option>
        <option value="4">健身操</option>
    </select>
</div>
<div>
    产品价格：<input id="price" name="price">
</div>
<input type="button" id="find" name="find" onclick="find()" value="查询"/>
<table class="table table-striped">
    <thead>
    <tr>
        <td>id</td>
        <td>产品名称</td>
        <td>产品类型</td>
        <td>产品图片</td>
        <td>产品价格</td>
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
