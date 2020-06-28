<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/28
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/js/jquery-3.5.1.js"></script>
<script>
    function addAbout() {
        // let data = {
        //     content: $("#content").val(),
        //     img: $("#img")[0].files[0]
        // };
        let data = new FormData();
        data.append("content", $("#content").val());
        data.append("img", $("#img")[0].files[0]);
        console.log(data);
        $.ajax({
            url: '/addAbout',
            type:'post',
            data:data,
            dataType:'json',
            contentType:false,
            processData:false,
            success:function (data) {
                if (data == 1) {
                    $("#homeright").load("/back/aboutList.jsp");
                }else {
                    alert("新增失败!")
                }
            }
        })
    }
</script>
<body>
<form>
    <div>
        内容信息：<textarea name="content" id="content"></textarea>
    </div>
    <div>图片：<input type="file" id="img" name="img"></div>
    <div>
        <input type="button" value="提交" onclick="addAbout()">
    </div>
</form>
</body>
</html>
