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
                $("#name").val(data.productModel.productName);
                $("#type").val(data.productModel.productType);
                $("#price").val(data.productModel.productPrice);
                let type = '';
                for (let i = 0; i < data.productTypeModelList.length; i++) {
                    type += '<option value="'+ data.productTypeModelList[i].id +'">'+ data.productTypeModelList[i].type +'</option>';
                }
                $("#type").html(type);
            }
        })
    }

    function editProductInfo() {
        // let data = {
        //     id:,
        //     name: $("#name").val(),
        //     type: $("#type").val(),
        //     price: $("#price").val(),
        //     img: $("#img")[0].files[0]
        // };
        let data = new FormData();
        data.append("id", localStorage.getItem("productId"));
        data.append("name", $("#name").val());
        data.append("type", $("#type").val());
        data.append("price", $("#price").val());
        data.append("img", $("#img")[0].files[0]);
        console.log(data)
        $.ajax({
            url: '/productEdit',
            type: 'post',
            data: data,
            dataType: 'json',
            contentType: false,
            processData: false,
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
<%--        <option value="1">杠铃</option>--%>
<%--        <option value="2">瑜伽</option>--%>
<%--        <option value="3">拳击</option>--%>
<%--        <option value="4">健身操</option>--%>
    </select>
</div>
<div>
    产品价格：<input type="text" name="price" id="price">
</div>
<div>产品图片：<label><input type="file" name="img" id="img" hidden>点击上传</label></div>
<div>
    <input type="button" value="提交" onclick="editProductInfo()">
</div>
</body>
</html>
