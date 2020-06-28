<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="../css/login.css">
</head>
<script src="/js/jquery-3.5.1.js"></script>
<script src="/js/user.js"></script>
<body>
	<div class="login">
		<div class="header">
			<h1>
				<a href="/jsp/login.jsp">登录</a> <a href="/jsp/register.jsp">注册</a>
			</h1>
		</div>
		<form>
			<table>
				<tr>
					<td class="td1">用户名</td>
					<td><input type="text" class="input1" id="username" name="username" onblur="changeUsername()"><span id="u_tishi"></span></td>
				</tr>
				<tr>
					<td class="td1">密码</td>
					<td><input type="password" class="input1" id="password" name="password" onblur="checkPassword()"><span id="p_tishi"></span></td>
				</tr>
				<tr>
					<td class="td1">验证码</td>
					<td><input type="text" style="width:100px;height:30px"  id="code" name="code"><img src="/code" style="width: 100px;height: 50px" onclick="flushImg(this)"></td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="btn-red">
							<input type="button" value="登录" id="login-btn" onclick="login()">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>