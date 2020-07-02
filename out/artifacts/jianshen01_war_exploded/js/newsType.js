$(function () {
    findAllNewsType();
})

function findAllNewsType() {
    $.ajax({
        url: '/newsTypeList',
        type:'get',
        dataType:'json',
        success:function (data) {
            setData(data);
        }
    })
}

function setData(data) {
    let html = '';
    for (let i = 0; i < data.length; i++) {
        html += '<tr>\n' +
            '<td>'+ data[i].id + '</td>\n' +
            '<td>'+ data[i].type + '</td>\n' +
            '<td>'+ data[i].status + '</td>\n' +
            '<td>'+ data[i].createTime + '</td>\n' +
            '</tr>';
    }
    $("#container").html(html);
}