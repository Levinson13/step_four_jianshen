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
                // console.log(data.img);
                $("#content").val(data.content);
            }
        })
    }

    function editAboutInfo() {
        let aboutId = localStorage.getItem("aboutId");
        // let data = new FormData();
        // data.append("content", $("#content").val());
        // data.append("img", $("#img").val());
        // data.append("id", aboutId);
        // let data = {
        //     content: $("#content").val(),
        //     img: $("#img")[0].files[0],
        //     id: aboutId,
        // };
        let data = new FormData();
        data.append("content", $("#content").val());
        data.append("img", $("#img")[0].files[0]);
        data.append("id", aboutId);
        // console.log($("#img")[0].files[0]);
        $.ajax({
            url:'/editAbout',
            type:'post',
            data:data,
            dataType: 'json',
            contentType: false,
            processData: false,
            success:function (data) {
                // console.log(data);
                if (data == 1) {
                    $("#homeright").load('/back/aboutList.jsp');
                }else {
                    alert("修改失败");
                }
            }
        })
    }
</script>
<body>
<form>
    <div>
        信息名称：<input type="text" name="content" id="content">
    </div>
    <div>
        信息图片：<label><input type="file" name="img" id="img" hidden>点击上传</label><span id="imgtext"></span>
    </div>
    <div>
        <input type="button" value="提交" onclick="editAboutInfo()">
    </div>
</form>
</body>
</html>
