<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/15
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/js/jquery-3.5.1.js"></script>
<%--<script src="/js/nav.js"></script>--%>
<script>
    $(function () {
        chaxunById();
    })

    function chaxunById() {
        let navId = localStorage.getItem("navId");
        console.log(navId);
        $.ajax({
            url: '/navFindById',
            data: {id: navId},
            type: 'get',
            dataType: 'json',
            success: function (data) {
                $("#href").val(data[0].href);
                $("#title").val(data[0].title);
                $("#status").val(data[0].status);
                if (status == 1) {
                    $("input[name='status'][value=启用]").attr("checked", true);
                } else {
                    $("input[name='status'][value=停用]").attr("checked", true);
                }
            }
        })
    }

    function editNavInfo() {
        let navId = localStorage.getItem("navId");
        console.log(navId)
        console.log($("#href").val());
        console.log($("#title").val());
        console.log($("input[name='status']").val());
        let data = {id: navId, href: $("#href").val(), title: $("#title").val(), status: $("input[name='status']").val()};
        $.ajax({
            url: '/navEdit',
            type: 'post',
            data: data,
            dataType: 'json',
            // processData: false,
            success: function (data) {
                console.log(1);
                if (data == "1") {
                    $("#homeright").load('/back/navList.jsp');
                } else {
                    alert("修改失败")
                }
            }
        })
    }
</script>
<body>

<div>
    导航链接：<input type="text" name="href" id="href">
</div>
<div>
    导航标题：<input type="text" name="title" id="title">
</div>
<div>
    状态：<label><input type="radio" name="status" value="启用">启用</label>
    <label><input type="radio" name="status" value="停用">停用</label>
</div>
<div>
    <input type="button" value="提交" onclick="editNavInfo()">
</div>
</body>
</html>
