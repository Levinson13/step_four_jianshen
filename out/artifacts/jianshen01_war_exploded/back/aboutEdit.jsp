<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/28
  Time: 14:54
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
        aboutFindById();
    })

    function aboutFindById() {
        let id = localStorage.getItem("aboutId");
        $.ajax({
            url: '/aboutFindById',
            type: 'get',
            data: {id: id},
            dataType: 'json',
            success: function (data) {
                console.log(data);
                $("#content").val(data.content);
                $("#img").val(data.img);
            }
        })
    }

    function editAboutInfo() {
        let aboutId = localStorage.getItem("coachId");
        let data = new FormData();
        data.append("content", $("#content").val());
        data.append("img", $("#img").val());
        data.append("id",aboutId)
        $.ajax({
            url:'/editAbout',
            type:'post',
            data:data,
            dataType: 'json',
            success:function (data) {
                console.log(data);
                if (data == "1") {
                    $("#homeright").load('/back/aboutList.jsp');
                }else {
                    alert("修改失败");
                }
            }
        })
    }
</script>
<body>
<div>
    教练名称：<input type="text" name="content" id="content">
</div>
<div>
    教练图片：<input type="text" name="img" id="img">
</div>
<div>
    <input type="button" value="提交" onclick="editAboutInfo()">
</div>
</body>
</html>
