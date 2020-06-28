<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link href="../css/reg.css" rel="stylesheet">
</head>
<script src="/js/jquery-3.5.1.js"></script>
<script src="/js/user.js"></script>
<body>
	<div class="reg">
		<div class="header">
			<h1>
				<a href="/jsp/login.jsp">登录</a> <a href="/jsp/register.jsp">注册</a>
			</h1>
		</div>
		<form>
			<table>
				<tr>
					<td class="td1">用户名</td>
					<td><input type="text" class="input1" name="username" id="username" onblur="changeUsername()"><span id="u_tishi"></span></td>
				</tr>
				<tr>
					<td class="td1">密码</td>
					<td><input type="password" class="input1" name="password" id="password" onblur="checkPassword()"><span id="p_tishi"></span></td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="btn-red">
							<input type="button" value="注册" id="reg-btn" onclick="register()">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>