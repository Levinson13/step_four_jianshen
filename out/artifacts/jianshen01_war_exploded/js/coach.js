$(function () {
    findAllCoach();
})

function findAllCoach() {
    $.ajax({
        url:'/coachList',
        type: 'get',
        dataType: 'json',
        success:function (data) {
            let post = '<option value="0">全部</option>';
            for (let i = 0; i < data.list.length; i++) {
                post += '<option value="'+ data.list[i].id +'">'+ data.list[i].post +'</option>';
            }
            $("#post").html(post);
            // console.log(JSON.stringify(data.object[0]));
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
    console.log(data);
    $.ajax({
        url:'/findCoachList',
        type:'get',
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
    // console.log(JSON.stringify(data));
    for (let i = 0; i < data.length; i++) {
        // console.log(data[i].coachModel.coachPost);
        // let result = judgePost(list,data[i].coachModel.coachPost);
        html += '<tr>\n' +
            '<td>'+ data[i].coachModel.id + '</td>\n' +
            '<td>'+ data[i].coachModel.coachName + '</td>\n' +
            '<td>'+ data[i].post + '</td>\n' +
            '<td><img src="'+ data[i].coachModel.coachImg + '" width="50px" href="50px"></td>\n' +
            '<td>'+ data[i].coachModel.createDate + '</td>\n' +
            '<td>'+ '<input type="button" value="编辑" onclick="edit('+ data[i].coachModel.id + ')"/>' + '<input type="button" value="删除" onclick="del('+ data[i].coachModel.id + ')"/> ' + '</td>\n' +
            '</tr>';
    }
    $("#container").html(html);
}

// function judgePost(data,type) {
//     let result;
//     for (let i = 0; i < data.length; i++) {
//         if (data[i].id == type) {
//             result = data[i].post;
//             break;
//         }
//     }
//     return result;
// }
