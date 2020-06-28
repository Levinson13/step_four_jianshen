<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/18
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/js/jquery-3.5.1.js"></script>
<script>
    function addNews() {
        // let data = {
        //     title: $("#title").val(),
        //     type: $("#type").val(),
        //     img: $("#img").file[0].files[0],
        //     content: $("#content").val()
        // };
        let data = new FormData();
        data.append("title", $("#title").val());
        data.append("type", $("#type").val());
        data.append("img", $("#img")[0].files[0]);
        data.append("content", $("#content").val());
        console.log(data);
        $.ajax({
            url:'/addNews',
            type: 'post',
            data:data,
            dataType:'json',
            contentType:false,
            processData:false,
            success:function (data) {
                if (data == 1) {
                    console.log(1);
                    $("#homeright").load("/back/newsList.jsp");
                }else {
                    console.log(0);
                    alert("新增失败");
                }
            }
        })
    }
</script>
<body>
<div>
    新闻标题：<input type="text" name="title" id="title">
</div>
<%--<div>--%>
<%--    新闻类别：<input type="text" name="type" id="type">--%>
<%--</div>--%>
<div>新闻类别：
    <select id="type" name = "type">
        <option value="1">公司信息</option>
        <option value="2">行业动态</option>
        <option value="3">媒体报道</option>
    </select>
</div>
<div>
    新闻图片：<input name="img" id="img" type="file">
</div>
<div>
    新闻内容：<textarea name="content" id="content"></textarea>
</div>

<div>
    <input type="button" value="提交" onclick="addNews()">
</div>
</body>
</html>
