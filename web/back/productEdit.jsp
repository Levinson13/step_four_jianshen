<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/17
  Time: 15:56
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
        productFindById();
    })

    function productFindById() {
        let id = localStorage.getItem("productId");
        $.ajax({
            url: '/productFindById',
            type: 'get',
            data: {id: id},
            dataType: 'json',
            success: function (data) {
                $("#name").val(data.productName);
                $("#type").val(data.productType);
                $("#img").val(data.productImg);
                $("#price").val(data.productPrice);
            }
        })
    }

    function editProductInfo() {
        let data = {
            name: $("#name").val(),
            type: $("#type").val(),
            img: $("#img").val(),
            price: $("#price").val(),
            id:localStorage.getItem("productId")
        };
        console.log(data)
        $.ajax({
            url: '/productEdit',
            type: 'post',
            data: data,
            dataType: 'json',
            success: function (data) {
                if (data == 1) {
                    $("#homeright").load("/back/productList.jsp");
                } else {
                    alert("编辑失败");
                }
            }
        })
    }
</script>
<body>
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
    产品图片：<input type="text" name="img" id="img">
</div>
<div>
    产品价格：<input type="text" name="price" id="price">
</div>
<div>
    <input type="button" value="提交" onclick="editProductInfo()">
</div>
</body>
</html>
