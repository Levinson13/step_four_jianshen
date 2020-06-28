<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/17
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="/js/jquery-3.5.1.js"></script>
<script>
    function addProduct() {
        // alert(111);
        // let data = {
        //     name: $("#name").val(),
        //     type: $("#type").val(),
        //     img: $("#img")[0].files[0],
        //     price: $("#price").val()
        // };
        let data = new FormData();
        data.append("name", $("#name").val());
        data.append("type",$("#type").val());
        data.append("img", $("#img")[0].files[0]);
        data.append("price", $("#price").val());
        $.ajax({
            url:'/addProduct',
            type: 'post',
            data : data,
            contentType:false,
            processData:false,
            dataType:'json',
            success:function (data) {
                if (data == 1) {
                    $("#homeright").load("/back/productList.jsp");
                }else {
                    alert("新增失败");
                }
            }
        })
    }
</script>
<body>
<form>
    <div>
        产品名称：<input type="text" name="name" id="name">
    </div>
    <div>产品类别：
        <select id="type" name = type>
            <option value="1">杠铃</option>
            <option value="2">瑜伽</option>
            <option value="3">拳击</option>
            <option value="4">健身操</option>
        </select>
    </div>
    <div>
        产品图片：<input type="file" name="img" id="img">
    </div>
    <div>
        产品价格：<input type="text" name="price" id="price">
    </div>
    <div>
        <input type="button" value="提交" onclick="addProduct()">
    </div>
</form>
</body>
</html>
