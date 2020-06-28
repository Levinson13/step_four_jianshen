<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/17
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/js/jquery-3.5.1.js"></script>
<script>
    function addStudent() {
        let data = new FormData();
        data.append("name", $("#name").val());
        data.append("phone", $("#phone").val());
        data.append("email", $("#email").val());
        data.append("content", $("#content").val());
        data.append("sex", $("#sex").val());
        data.append("age", $("#age").val());
        data.append("password", $("#password").val());
        data.append("img", $("#img")[0].files[0]);
        // let data = {
        //     name: $("#name").val(),
        //     phone: $("#phone").val(),
        //     email: $("#email").val(),
        //     content: $("#content").val(),
        //     img: $("#img").val(),
        //     sex: $("#sex").val(),
        //     age: $("#age").val(),
        //     password:$("#password").val()
        // };
        $.ajax({
            url:'/addStudent',
            type:'post',
            data:data,
            contentType:false,
            processData:false,
            dataType:'json',
            success:function (data) {
                if (data == 1) {
                    $("#homeright").load("/back/studentList.jsp");
                }else {
                    alert("新增失败");
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
<div>图片：<input type="file" id="img" name="img"></div>
<div>性别：<select id="sex">
                <option value="1">男</option>
                <option value="2">女</option>
           </select>
</div>
<div>年龄：<input type="text" id="age" name="age"></div>
<div><input type="button" value="提交" onclick="addStudent()"></div>
</body>
</html>
