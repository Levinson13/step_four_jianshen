<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/17
  Time: 17:09
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
        studentFindById();
    })

    function studentFindById() {
        let id = localStorage.getItem("stuId");
        // console.log(id)
        $.ajax({
            url:'/studentFindById',
            type:'post',
            data:{id:id},
            dataType:'json',
            success:function (data) {
                if (data.stuImg != "undefined") {
                    $("#hiddenImg").val(data.stuImg);
                    let imgHtml = '图片：<input type="text" value="'+ data.stuImg +'" id="img" name="img" readonly>';
                    $("#imgHtml").html(imgHtml);
                } else {
                    let imgHtml = '图片：<input type="file" id="img" name="img">';
                    $("#imgHtml").html(imgHtml);
                }
                console.log($("#hiddenImg").val());
                console.log("data:" + JSON.stringify(data));
                $("#name").val(data.stuName);
                $("#phone").val(data.stuPhone);
                $("#email").val(data.stuEmail);
                $("#content").val(data.stuContent);
                // $("#img").val( $("#img")[0].files[0]);
                $("#sex").val(data.stuSex);
                $("#age").val(data.stuAge);
                $("#password").val(data.stuPassword);

            }
        })
    }

    function editStudentInfo() {
        // let data = {
        //     id: localStorage.getItem("stuId"),
        //     name: $("#name").val(),
        //     phone: $("#phone").val(),
        //     email: $("#email").val(),
        //     content: $("#content").val(),
        //     img: $("#img")[0].files[0],
        //     sex: $("#sex").val(),
        //     age: $("#age").val(),
        //     password:$("#password").val()
        // };
        let data = new FormData();
        data.append("id", localStorage.getItem("stuId"));
        data.append("name", $("#name").val());
        data.append("password", $("#password").val());
        data.append("phone", $("#phone").val());
        data.append("email", $("#email").val());
        data.append("content", $("#content").val());
        data.append("sex", $("#sex").val());
        data.append("age", $("#age").val());
        data.append("img", $("#img").val());
        console.log(JSON.stringify(data))
        $.ajax({
            url:'/editStudent',
            type:'post',
            data:data,
            dataType:'json',
            contentType:false,
            processData:false,
            success:function (data) {
                if (data == 1) {
                    $("#homeright").load("/back/studentList.jsp");
                }else {
                    alert("修改失败");
                }
            }
        })
    }
</script>
<body>
<div>姓名：<input type="text" id="name" name="name"></div>
<div>密码：<input type="text" id="password" name="password"></div>
<div>电话：<input type="text" id="phone" name="phone"></div>
<div>邮箱：<input type="text" id="email" name="email"></div>
<div>内容：<input type="text" id="content" name="content"></div>
<div><input type="hidden" id="hiddenImg" name="hiddenImg"></div>
<%--<div>图片：<input type="file" id="img" name="img"></div>--%>
<div id="imgHtml"></div>
<div>性别：<select id="sex">
    <option value="1">男</option>
    <option value="2">女</option>
</select>
</div>
<div>年龄：<input type="text" id="age" name="age"></div>
<div><input type="button" value="提交" onclick="editStudentInfo()"></div>
</body>
</html>
