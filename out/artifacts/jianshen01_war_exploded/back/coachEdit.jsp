<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/16
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
    $(function () {
        coachFindById();
    })

    function coachFindById() {
        let id = localStorage.getItem("coachId");
        $.ajax({
            url: '/coachFindById',
            type: 'get',
            data: {id: id},
            dataType: 'json',
            success: function (data) {
                console.log(data);
                $("#name").val(data.coachModel.coachName);
                $("#post").val(data.coachModel.coachPost);
                let html = '';
                for (let i = 0; i < data.coachPostModelList.length; i++) {
                    html += '<option value="'+ data.coachPostModelList[i].id +'">'+ data.coachPostModelList[i].post +'</option>';
                }
                $("#post").html(html);
            }
        })
    }

    function editCoachInfo() {
        let coachId = localStorage.getItem("coachId");
        // let data = {
        //     name: $("#name").val(),
        //     post: $("#post").val(),
        //     img: $("#img").val(),
        //     id: coachId
        // };
        let data = new FormData();
        data.append("id", coachId);
        data.append("name", $("#name").val());
        data.append("post", $("#post").val());
        data.append("img", $("#img")[0].files[0]);
        $.ajax({
            url:'/editCoach',
            type:'post',
            data:data,
            dataType: 'json',
            contentType: false,
            processData: false,
            success:function (data) {
                console.log(data);
                if (data == "1") {
                    $("#homeright").load('/back/coachList.jsp');
                }else {
                    alert("修改失败");
                }
            }
        })
    }
</script>
<body>
<div>
    教练名称：<input type="text" name="name" id="name">
</div>
<div>教练职务：
    <select id="post" name="post">
<%--        <option value="1">一级健身员</option>--%>
<%--        <option value="2">二级健身员</option>--%>
<%--        <option value="3">格斗教练</option>--%>
<%--        <option value="4">金牌健身教练</option>--%>
<%--        <option value="5">银牌健身教练</option>--%>
<%--        <option value="6">铜牌健身教练</option>--%>
    </select>
</div>
<%--<div>--%>
<%--    教练图片：<input type="text" name="img" id="img">--%>
<%--</div>--%>
<div>教练图片：<label><input type="file" name="img" id="img" hidden>点击上传</label></div>
<div>
    <input type="button" value="提交" onclick="editCoachInfo()">
</div>
</body>
</html>
