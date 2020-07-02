function findAllProduct() {
    $.ajax({
        url:'/productList',
        type:'get',
        dataType: 'json',
        success:function (data) {
            let type = '<option value="0">全部</option>';
            for (let i = 0; i < data.list.length; i++) {
                type += '<option value="'+ data.list[i].id +'">'+ data.list[i].type +'</option>';
            }
            $("#type").html(type);
            setData(data.object);
            $("#pageCount").html(data.count);

        }
    })
}

function del(id){
    $.ajax({
        url:'/delProduct',
        type:'get',
        data:{id:id},
        dataType: 'json',
        success:function (data) {
            if (data == 1) {
                findAllProduct();
            }else{
                alert("删除失败");
            }
        }
    })
}

function edit(id) {
    localStorage.setItem("productId", id);
    $("#homeright").load("/back/productEdit.jsp");
}

function find() {
    let data={
        name: $("#name").val(),
        type: $("#type").val(),
        price: $("#price").val(),
        pageSize: $("#pageSize").val(),
        pageNum:$("#pageNum").val()
    };
    $.ajax({
        url:'/findProductList',
        type:'get',
        data:data,
        dataType:'json',
        success:function (data) {
            setData(data.object);
        }
    })
}
function setData(data) {
    let html = '';
    for (let i=0;i<data.length;i++){
        // let result = judgeType(data[i].productType);
        html += '<tr>\n' +
            '<td>' + data[i].productModel.id  + '</td>>\n' +
            '<td>' + data[i].productModel.productName  + '</td>>\n' +
            '<td>' + data[i].type  + '</td>>\n' +
            '<td><img src="'+ data[i].productModel.productImg + '" width="50px" href="50px"></td>>\n' +
            '<td>' + data[i].productModel.productPrice  + '</td>>\n' +
            '<td>' + data[i].productModel.createDate  + '</td>>\n' +
            '<td>'+ '<input type="button" value="编辑" onclick="edit('+ data[i].productModel.id + ')"/>' + '<input type="button" value="删除" onclick="del('+ data[i].productModel.id + ')"/> ' + '</td>\n' +
            '</tr>';
    }
    $("#container").html(html);
}
//
// function judgeType(type) {
//     let result;
//     switch (type) {
//         case 1:
//             result = '杠铃';
//             break;
//         case 2:
//             result = '瑜伽';
//             break;
//         case 3:
//             result = '拳击';
//             break;
//         case 4:
//             result = '健身操';
//             break;
//     }
//     return result;
// }
