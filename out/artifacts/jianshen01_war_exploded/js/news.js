$(function () {
    findAllNews();
})

function findAllNews() {
    $.ajax({
        url:'/newsList',
        type:'get',
        dataType: 'json',
        success:function (data) {
            setData(data.object);
            $("#pageCount").html(data.count);
        }
    })
}

function del(id){
    $.ajax({
        url:'/delNews',
        type:'get',
        data:{id:id},
        dataType: 'json',
        success:function (data) {
            if (data == 1) {
                findAllNews();
            }else{
                alert("删除失败");
            }
        }
    })
}

function edit(id) {
    localStorage.setItem("newsId", id);
    $("#homeright").load("/back/newsEdit.jsp");
}

function find() {
    let data = {
        title: $("#title").val(),
        type: $("#type").val(),
        content:$("#content").val(),
        pageNum:$("#pageNum").val(),
        pageSize :$("#pageSize").val()
    };
    $.ajax({
        url:'/findNewsList',
        type:'get',
        data:data,
        dataType: 'json',
        success:function (data) {
            // console.log(JSON.stringify(data.object));
            // let html = '';
            // for (let i=0;i<data.length;i++){
            //     console.log(data.object[i].newsTitle);
            //     html += '<tr>\n' +
            //         '<td>' + data.object[i].id  + '</td>>\n' +
            //         '<td>' + data.object[i].newsTitle  + '</td>>\n' +
            //         '<td>' + data.object[i].newsType  + '</td>>\n' +
            //         '<td>' + data.object[i].newsContent  + '</td>>\n' +
            //         '<td>' + data.object[i].createTime  + '</td>>\n' +
            //         '<td>'+ '<input type="button" value="编辑" onclick="edit('+ data.object[i].id + ')"/>' + '<input type="button" value="删除" onclick="del('+ data.object[i].id + ')"/> ' + '</td>\n' +
            //         '</tr>';
            // }
            // $("#container").html(html);
            setData(data.object);
            console.log(111);
        }
    })
}

function setData(data) {
    let html = '';
    for (let i=0;i<data.length;i++){
        let result = judgeType(data[i].newsType);
        html += '<tr>\n' +
            '<td>' + data[i].id  + '</td>>\n' +
            '<td>' + data[i].newsTitle  + '</td>>\n' +
            '<td>' + result  + '</td>>\n' +
            '<td><img src="'+ data[i].newsImg + '" width="50px" href="50px"></td>>\n' +
            '<td>' + data[i].newsContent  + '</td>>\n' +
            '<td>' + data[i].createDate  + '</td>>\n' +
            '<td>'+ '<input type="button" value="编辑" onclick="edit('+ data[i].id + ')"/>' + '<input type="button" value="删除" onclick="del('+ data[i].id + ')"/> ' + '</td>\n' +
            '</tr>';
    }
    $("#container").html(html);
}

function judgeType(type) {
    let result;
    switch (type) {
        case 1:
            result = '公司信息';
            break;
        case 2:
            result = '行业动态';
            break;
        case 3:
            result = '媒体报道';
            break;
    }
    return result;
}
