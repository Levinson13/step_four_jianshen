$(function () {
    findAllAbout();
})

function findAllAbout() {
    $.ajax({
        url:'/aboutList',
        type: 'get',
        dataType: 'json',
        success:function (data) {
            setData(data.object);
            $("#pageCount").html(data.count);
        }
    })
}

function edit(id) {
    localStorage.setItem("aboutId", id);
    $("#homeright").load("/back/aboutEdit.jsp");
}

function del(id) {
    $.ajax({
        url:'/delAbout',
        type:'get',
        data:{id:id},
        dataType: 'json',
        success:function (data) {
            if (data == "1") {
                findAllAbout();
            }else{
                alert("删除失败");
            }
        }
    })
}

function find() {
    let data = {
        content: $("#aboutcontent").val(),
        pageSize: $("#pageSize").val(),
        pageNum: $("#pageNum").val()
    };
    console.log(data);
    $.ajax({
        url:'/findAboutList',
        type:'post',
        data:data,
        dataType: 'json',
        success:function (data) {
            console.log(JSON.stringify(data));
            setData(data.object);
        }
    })
}

function setData(data) {
    let html = '';
    for (let i = 0; i < data.length; i++) {
        html += '<tr>\n' +
            '<td>'+ data[i].id + '</td>\n' +
            '<td>'+ data[i].content + '</td>\n' +
            '<td><img src="'+ data[i].img + '" width="50px" href="50px"></td>\n' +
            '<td>'+ data[i].createTime + '</td>\n' +
            '<td>'+ '<input type="button" value="编辑" onclick="edit('+ data[i].id + ')"/>' + '<input type="button" value="删除" onclick="del('+ data[i].id + ')"/> ' + '</td>\n' +
            '</tr>';
    }
    $("#container").html(html);
}