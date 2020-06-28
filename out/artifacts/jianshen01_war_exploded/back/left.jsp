<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/12
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单</title>
    <script src="/js/nav.js"></script>
</head>
<body>
<ul class="caidan">
    <li>导航管理
        <ol>
            <a href="javascript:$('#homeright').load('/back/navList.jsp')"><li>导航查询</li></a>
            <a href="javascript:$('#homeright').load('/back/navAdd.jsp')"><li>导航新增</li></a>
        </ol>
    </li>
    <li>公司信息
        <ol>
            <a href="javascript:$('#homeright').load('/back/aboutList.jsp')"><li>公司信息查询</li></a>
            <a href="javascript:$('#homeright').load('/back/aboutAdd.jsp')"><li>公司信息新增</li></a>
        </ol>
    </li>
    <li>新闻管理
        <ol>
            <a href="javascript:$('#homeright').load('/back/newsList.jsp')"><li>新闻查询</li></a>
            <a href="javascript:$('#homeright').load('/back/newsAdd.jsp')"><li>新闻新增</li></a>
        </ol>
    </li>
    <li>教练管理
        <ol>
            <a href="javascript:$('#homeright').load('/back/coachList.jsp')"><li>教练查询</li></a>
            <a href="javascript:$('#homeright').load('/back/coachAdd.jsp')"><li>教练新增</li></a>
        </ol>
    </li>
    <li>产品管理
        <ol>
            <a href="javascript:$('#homeright').load('/back/productList.jsp')"><li>产品查询</li></a>
            <a href="javascript:$('#homeright').load('/back/productAdd.jsp')"><li>产品新增</li></a>
        </ol>
    </li>
    <li>学生管理
        <ol>
            <a href="javascript:$('#homeright').load('/back/studentList.jsp')"><li>学员查询</li></a>
            <a href="javascript:$('#homeright').load('/back/studentAdd.jsp')"><li>学员新增</li></a>
        </ol>
    </li>
</ul>
</body>
</html>
