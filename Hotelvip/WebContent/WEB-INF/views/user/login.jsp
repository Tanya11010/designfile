<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//获取的是网站的名称
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//http://127.0.0.1:8080/rolesys/
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录本酒店会员管理系统</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="static/js/jquery.js"></script>
<script src="static/js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
	});
</script>
</head>

<body
	style="background-color: #1c77ac; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">
	<form action="${pageContext.request.contextPath }/user/login"
		method="post">
		<input type="hidden" value="${token}" name="token">

		<div id="mainBody">
			<div id="cloud1" class="cloud"></div>
			<div id="cloud2" class="cloud"></div>
		</div>


		<div class="logintop">
			<span>欢迎登录酒店会员管理系统界面平台</span>

		</div>

		<div class="loginbody">

			<span class="systemlogo"></span>

			<div class="loginbox">

				<ul class="loginbut">
					<li style="height: 30px;" colspan="2"><span style="color: red">${msg }</span></li>
					<li><input name="username" type="text" class="loginuser"
						value="用户名" onclick="JavaScript:this.value=''" /></li>
					<li><input name="userpass" type="password" class="loginpwd"
						value="密码" onclick="JavaScript:this.value=''" /></li>
					<label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input
						name="radio" type="radio" value="adminrad" />管理员登录
					</label>&nbsp&nbsp&nbsp&nbsp
					<label><input name="radio" type="radio" value="userrad" />会员登录</label>


					<li><input name="imagecode" type="text" class="loginyzm"
						value="验证码" width="150px" onclick="JavaScript:this.value=''" /> <img
						src="${pageContext.request.contextPath }/imagecode" id="imgid"
						style="position: relative; top: 15px;">
					</td> <script type="text/javascript">
						window.onload = function() {
							var img = document.getElementById("imgid");
							img.onclick = function() {

								Math.random()
								this.src = "${pageContext.request.contextPath }/imagecode?r="
										+ Math.random();
							}
						}
					</script></li>
					<!-- onclick="javascript:window.location='main.html'"   -->
					<li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input name="login"
						type="submit" class="loginbtn" value="登录" />&nbsp&nbsp&nbsp&nbsp
						<input name="reset" type="reset" class="loginbtn" value="重置" />

					</li>
				</ul>


			</div>

		</div>



		<div class="loginbm">
			版权所有 2017 <a href="http://www.mycodes.net">酒店会员管理系统</a>
		</div>

	</form>
</body>
</html>