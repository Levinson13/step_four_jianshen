<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/18
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/js/jquery-3.5.1.js"></script>
<script>
    $(function () {
        newsFindById();
    })
    function newsFindById() {
        let id = localStorage.getItem("newsId");
        console.log(id)
        $.ajax({
            url:'/newsFindById',
            type:'post',
            data:{id:id},
            dataType:'json',
            success:function (data) {
                $("#title").val(data.newsTitle);
                $("#type").val(data.newsType);
                $("#content").val(data.newsContent);
            }
        })
    }
    function editNewsInfo() {
        let data = {
            id : localStorage.getItem("newsId"),
            title: $("#title").val(),
            type: $("#type").val(),
            content: $("#content").val(),
        };
        $.ajax({
            url:'/editNews',
            type:'post',
            data:data,
            dataType:'json',
            success:function (data) {
                if (data == 1) {
                    $("#homeright").load("/back/newsList.jsp");
                }else {
                    alert("修改失败");
                }
            }
        })
    }

</script>
<body>
<div>标题：<input type="text" id="title" name="title"></div>
<div>类别：
    <select id="type" name = type>
        <option value="1">公司信息</option>
        <option value="2">行业动态</option>
        <option value="3">媒体报道</option>
    </select>
</div>
<div>内容：<input type="text" id="content" name="content"></div>
<div><input type="button" value="提交" onclick="editNewsInfo()"></div>
</body>
</html>
