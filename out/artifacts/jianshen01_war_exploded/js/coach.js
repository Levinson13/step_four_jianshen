$(function () {
    findAllCoach();
})

function findAllCoach() {
    $.ajax({
        url:'/coachList',
        type: 'get',
        dataType: 'json',
        success:function (data) {
            setData(data.object);
            // let html = '';
            // for (let i = 0; i < data.length; i++) {
            //     html += '<tr>\n' +
            //         '<td>'+ data[i].id + '</td>\n' +
            //         '<td>'+ data[i].coachName + '</td>\n' +
            //         '<td>'+ data[i].coachPost + '</td>\n' +
            //         '<td>'+ data[i].coachImg + '</td>\n' +
            //         '<td>'+ '<input type="button" value="编辑" onclick="edit('+ data.id + ')"/>' + '<input type="button" value="删除" onclick="del('+ data.id + ')"/> ' + '</td>\n' +
            //         '</tr>';
            // }
            // $("#container").html(html);
            $("#pageCount").html(data.count);
        }
    })
}

function del(id) {
    $.ajax({
        url:'/delCoach',
        type:'get',
        data:{id:id},
        dataType: 'json',
        success:function (data) {
            if (data == "1") {
                findAllCoach();
            }else{
                alert("删除失败");
            }
        }
    })
}

function edit(id) {
    localStorage.setItem("coachId", id);
    $("#homeright").load("/back/coachEdit.jsp");
}

function find() {
    let data = {
        coachname: $("#coachname").val(),
        post: $("#post").val(),
        pageSize: $("#pageSize").val(),
        pageNum:$("#pageNum").val()
    };
    $.ajax({
        url:'/findCoachList',
        type:'get',
        data:data,
        dataType: 'json',
        success:function (data) {
            console.log(JSON.stringify(data.object));
            setData(data.object);
        }
    })
}
function setData(data) {
    let html = '';
    for (let i = 0; i < data.length; i++) {
        let result = judgePost(data[i].coachPost);
        html += '<tr>\n' +
            '<td>'+ data[i].id + '</td>\n' +
            '<td>'+ data[i].coachName + '</td>\n' +
            '<td>'+ result + '</td>\n' +
            '<td><img src="'+ data[i].coachImg + '" width="50px" href="50px"></td>\n' +
            '<td>'+ data[i].createDate + '</td>\n' +
            '<td>'+ '<input type="button" value="编辑" onclick="edit('+ data[i].id + ')"/>' + '<input type="button" value="删除" onclick="del('+ data[i].id + ')"/> ' + '</td>\n' +
            '</tr>';
    }
    $("#container").html(html);
}

function judgePost(type) {
    let result;
    switch (type) {
        case 1:
            result = '一级健身员';
            break;
        case 2:
            result = '二级健身员';
            break;
        case 3:
            result = '格斗教练';
            break;
        case 4:
            result = '金牌健身教练';
            break;
        case 5:
            result = '银牌健身教练';
            break;
        case 6:
            result = '铜牌健身教练';
            break;
    }
    return result;
}