$(function () {
    findStudentList()
})
function findStudentList() {
    $.ajax({
        url:'/studentList',
        type:'get',
        dataType: 'json',
        success:function (data) {
            let size = data.count % data.object.length != 0 ? Math.ceil(data.count / data.object.length) : data.count / data.object.length;
            let html = '';
            console.log(JSON.stringify(data.object));
            for (let i=0;i<data.count;i++){
                let aa = data.object[i];
                let sex = '';
                if (1 == aa.stuSex) {
                    sex = '男';
                }else {
                    sex = '女';
                }
                html += '<tr>\n' +
                    '<td>' + aa.id  + '</td>>\n' +
                    '<td>' + aa.stuName  + '</td>>\n' +
                    '<td>' + aa.stuPassword  + '</td>>\n' +
                    '<td>' + aa.stuPhone  + '</td>>\n' +
                    '<td>' + aa.stuEmail  + '</td>>\n' +
                    '<td>' + aa.stuContent  + '</td>>\n' +
                    '<td><img src="'+ aa.stuImg + '" width="50px" href="50px"></td>>\n' +
                    '<td>' + sex +'</td>>\n' +
                    '<td>' + aa.stuAge  + '</td>>\n' +
                    '<td>' + aa.createDate  + '</td>>\n' +
                    '<td>'+ '<input type="button" value="编辑" onclick="edit('+ aa.id + ')"/>' + '<input type="button" value="删除" onclick="del('+ aa.id + ')"/> ' + '</td>\n' +
                    '</tr>';
            }
            $("#container").html(html);
            // $("#totalPage").html(size);
            $("#pageCount").html(data.count);
        }
    });
}

function del(id) {
    $.ajax({
        url:'/delStudent',
        type:'get',
        data:{id:id},
        dataType: 'json',
        success:function (data) {
            if (data == 1) {
                findStudentList();
            }else {
                alert("删除失败");
            }
        }
    })
}

function edit(id) {
    localStorage.setItem("stuId", id);
    $("#homeright").load("/back/studentEdit.jsp");
}

function find() {
    let data = {
        username: $("#username").val(),
        password: $("#password").val(),
        sex: $("#sex").val(),
        startAge : $("#start-age").val(),
        endAge: $("#end-age").val(),
        pageSize: $("#pageSize").val(),
        pageNum:$("#pageNum").val()
    };
    // console.log(data);
    $.ajax({
        url:'/findStudentList',
        type:'get',
        data:data,
        dataType: 'json',
        success:function (data) {
            console.log(JSON.stringify(data.object));
            let html = '';
            $("#pageCount").html(data.count);
            for (let i=0;i<data.object.length;i++){
                let aa = data.object[i];
                let sex = '';
                if ("1" == aa.stuSex) {
                    sex = '男';
                }else {
                    sex = '女';
                }
                html += '<tr>\n' +
                    '<td>' + aa.id  + '</td>>\n' +
                    '<td>' + aa.stuName  + '</td>>\n' +
                    '<td>' + aa.stuPassword  + '</td>>\n' +
                    '<td>' + aa.stuPhone  + '</td>>\n' +
                    '<td>' + aa.stuEmail  + '</td>>\n' +
                    '<td>' + aa.stuContent  + '</td>>\n' +
                    '<td><img src="'+ aa.stuImg + '" width="50px" href="50px"></td>>\n' +
                    '<td>' + sex  + '</td>>\n' +
                    '<td>' + aa.stuAge  + '</td>>\n' +
                    '<td>' + aa.createCreate  + '</td>>\n' +
                    '</tr>';
            }
            $("#container").html(html);
            // $("#totalPage").html(size);
        }
    });
}