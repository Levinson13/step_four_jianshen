let resultU = false;
let resultP = false;

function changeUsername() {
    let username = document.getElementById("username").value;
    let reg = /^[a-zA-Z]\w{5,15}$/;
    if (reg.test(username)) {
        resultU = true;
        document.getElementById("u_tishi").innerHTML = "你输入正确";
        document.getElementById("u_tishi").style.color = "green";
    } else {
        resultU = false;
        document.getElementById("p_tishi").style.color = "red";
        document.getElementById("p_tishi").innerHTML = "你输入不符合规范";
    }

}

function checkPassword() {
    let password = $("#password").val();
    let reg = /^[a-zA-Z]\w{5,15}$/;
    if (reg.test(password)) {
        resultP = true;
        document.getElementById("u_tishi").innerHTML = "你输入正确";
        document.getElementById("u_tishi").style.color = "green";
    } else {
        resultP = false;
        document.getElementById("p_tishi").style.color = "red";
        document.getElementById("p_tishi").innerHTML = "你输入不符合规范";
    }
    // alert(reg.test(password));
}

function judge() {
    if (resultP && resultU) {
        return true;
    }
    return false;
}

function login() {
    let data = {
        username: $("#username").val(),
        password: $("#password").val(),
        code:$("#code").val()
    };
    // let data = new FormData();
    // data.append("username", $("#username").val());
    // data.append("password", $("#password").val());
    if (judge()) {
        $.ajax({
            url : '/login',
            type: 'post',
            data : data,
            dataType : 'json',
            success : function (data) {
                if (data == 1) {
                    window.location.href = "../back/home.jsp";
                }else {
                    alert("登录失败");
                    window.location.href = "../jsp/login.jsp";
                }
            }
        });
    }
}

function register() {
    let data = {
        username: $("#username").val(),
        password: $("#password").val()
    };
    $.ajax({
        url : '/register',
        type: 'post',
        data : data,
        dataType : 'json',
        success : function (data) {
            if (data == 1) {
                alert("注册成功");
                window.location.href = "../jsp/login.jsp";
            }else {
                alert("用户名已存在");
                window.location.href = "../jsp/register.jsp";
            }
        }
    })
}

function flushImg(e) {
    $(e).attr("src","/code?data=" + Math.random())
}
