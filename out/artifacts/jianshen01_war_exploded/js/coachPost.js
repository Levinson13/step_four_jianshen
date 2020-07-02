$(function () {
    findAllCoachPost();
})

function findAllCoachPost() {
    $.ajax({
        url: '/coachPostList',
        type:'get',
        dataType:'json',
        success:function (data) {
            setData(data);
        }
    })
}

function del(id) {
    $.ajax({
        url:'/delCoachPost',
        type: 'post',
        data:{id: id},
        dataType: 'json',
        success:function (data) {
            if (data == 1) {
                $("#homeright").load("/back/coachPostList.jsp");
            }else {
                alert("删除失败!")
            }
        }
    })
}

function setData(data) {
    let html = '';
    console.log(data);
    for (let i = 0; i < data.length; i++) {
        let status = '';
        if (data[i].status == 1) {
            status = '启用';
        }else{
            status = '禁用';
        }
        html += '<tr>\n' +
            '<td>'+ data[i].id + '</td>\n' +
            '<td>'+ data[i].post + '</td>\n' +
            '<td>'+ status + '</td>\n' +
            '<td>'+ data[i].createTime + '</td>\n' +
            '</tr>';
    }
    $("#container").html(html);
}