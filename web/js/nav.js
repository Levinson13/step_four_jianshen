$(function () {
    chaxun();
})

function chaxun() {
    $.ajax({
        url: '/navList',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            var html = '';
            for (var i = 0; i < data.length; i++) {
                var status = data[i].status
                status = status == 1 ? "启用" : "停用";
                html += '<tr>\n' +
                    '<td>' + data[i].id + '</td>\n' +
                    '<td>' + data[i].href + '</td>\n' +
                    '<td>' + data[i].title + '</td>\n' +
                    '<td>' + status + '</td>\n' +
                    '<td>' + '<input type="button" value="编辑" onclick="edit(' + data[i].id + ')"/>' + '<input type="button" value="删除" onclick="del(' + data[i].id + ')"/> ' + '</td>\n' +
                    '</tr>';
            }
            $("#container").html(html);
        },
        error: function () {
            alert(1);
        }
    })
}

function del(id) {
    $.ajax({
        url: '/navDel',
        type: 'post',
        data: {id: id},
        dataType: 'json',
        success: function (data) {
            if (data == "1") {
                chaxun();
            } else {
                alert("删除失败")
            }
        },
        error: function () {
            alert("没进到success")
        }
    });
}

function edit(id) {
    localStorage.setItem("navId", id);
    $("#homeright").load('/back/navEdit.jsp');
}

