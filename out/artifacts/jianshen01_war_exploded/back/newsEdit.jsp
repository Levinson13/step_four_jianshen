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
        $.ajax({
            url:'/newsFindById',
            type:'post',
            data:{id:id},
            dataType:'json',
            success:function (data) {
                $("#title").val(data.newsModel.newsTitle);
                $("#type").val(data.newsModel.newsType);
                $("#content").val(data.newsModel.newsContent);
                let html = '';
                for (let i = 0; i < data.newsTypeModelList.length; i++) {
                    html += '<option value="'+ data.newsTypeModelList[i].id +'">'+ data.newsTypeModelList[i].type +'</option>';
                }
                $("#type").html(html);
            }
        })
    }
    function editNewsInfo() {
        // let data = {
        //     id : localStorage.getItem("newsId"),
        //     title: $("#title").val(),
        //     type: $("#type").val(),
        //     content: $("#content").val(),
        //     img: $("#img")[0].files[0]
        // };
        let data = new FormData();
        data.append("id", localStorage.getItem("newsId"));
        data.append("title", $("#title").val());
        data.append("type", $("#type").val());
        data.append("content", $("#content").val());
        data.append("img", $("#img")[0].files[0]);
        console.log(data);
        $.ajax({
            url:'/editNews',
            type:'post',
            data:data,
            dataType:'json',
            contentType: false,
            processData: false,
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
<%--        <option value="1">公司信息</option>--%>
<%--        <option value="2">行业动态</option>--%>
<%--        <option value="3">媒体报道</option>--%>
    </select>
</div>
<div>内容：<input type="text" id="content" name="content"></div>
<div>图片：<label><input type="file" name="img" id="img" hidden>点击上传</label></div>
<div><input type="button" value="提交" onclick="editNewsInfo()"></div>
</body>
</html>
