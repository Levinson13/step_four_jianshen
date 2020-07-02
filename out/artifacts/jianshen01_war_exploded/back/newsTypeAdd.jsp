<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/16
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/js/jquery-3.5.1.js"></script>
<%--<script src="/js/coach.js"></script>--%>
<script>
    function addNewsType() {
        // let data = new FormData();
        // data.append("post",$("#post").val());
        // data.append("status",$("#status").val());
        let data = {
            post:$("#post").val(),
            status:$("#status").val()
        };
        $.ajax({
            url: '/addNewsType',
            type: 'post',
            data: data,
            dataType: 'json',
            success: function (data) {
                if (data == 1) {
                    $("#homeright").load("/back/newsTypeList.jsp");
                } else {
                    alert("新增失败");
                }
            }
        })
    }
</script>
<body>
<form>
    <div>
        职务名称：<input type="text" name="post" id="post">
    </div>
    <select name="status" id="status">
        <option value="1">启用</option>
        <option value="0">禁用</option>
    </select>
    <div>
        <input type="button" value="提交" onclick="addNewsType()">
    </div>
</form>
</body>
</html>
