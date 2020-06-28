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
    function addCoach() {
        // let data = {
        //     name: $("#name").val(),
        //     post: $("#post").val(),
        //     img: $("#img").val()
        // };
        let data = new FormData();
        data.append("name",$("#name").val());
        data.append("post",$("#post").val());
        data.append("img", $("#img")[0].files[0]);
        console.log($("#img")[0]);
        $.ajax({
            url: '/addCoach',
            type: 'post',
            data: data,
            contentType:false,
            processData:false,
            dataType: 'json',
            success: function (data) {
                if (data == "1") {
                    $("#homeright").load("/back/coachList.jsp");
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
        教练名称：<input type="text" name="name" id="name">
    </div>
<%--    <div>--%>
<%--        教练职务：<input type="text" name="post" id="post">--%>
<%--    </div>--%>
    <div>教练职务：
        <select id="post" name="post">
            <option value="1">一级健身员</option>
            <option value="2">二级健身员</option>
            <option value="3">格斗教练</option>
            <option value="4">金牌健身教练</option>
            <option value="5">银牌健身教练</option>
            <option value="6">铜牌健身教练</option>
        </select>
    </div>
    <div>图片：<input type="file" id="img" name="img"></div>
    <div>
        <input type="button" value="提交" onclick="addCoach()">
    </div>
</form>
</body>
</html>
