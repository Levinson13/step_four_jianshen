<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/12
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<script src="/js/jquery-3.5.1.js"></script>
<script>
    function tijiao() {
        let data = {href:$("#href").val(),title:$("#title").val()};
        console.log(data);
        $.ajax({
            url : '/navAdd',
            type: 'post',
            data : data,
            dataType : 'json',
            success : function (data) {
                console.log(1111);
                if (data == "1") {
                    $('#homeright').load('/back/navList.jsp');
                }else {
                    alert("操作失败")
                }
            }
        });
    }
</script>
<body>
<form>
    <div>
        导航链接：<input type="text" name="href" id="href">
    </div>
    <div>
        导航标题：<input type="text" name="title" id="title">
    </div>
    <div>
        <input type="button" value="提交" onclick="tijiao()">
    </div>
</form>
</body>
</html>
