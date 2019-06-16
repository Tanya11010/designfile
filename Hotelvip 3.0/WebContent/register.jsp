<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%
String path = request.getContextPath();//获取的是网站的名称
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
	<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="static/css/style.css" rel="stylesheet" type="text/css" />
		<%
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
   		 String date= format.format(new Date());
		%>
	</head>

	<body>
	<form action="<%=request.getContextPath() %>/registeruser" method="post" >
	
	 <input type="hidden" name="time" value="<%=date%>"/>
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					<a href="http://127.0.0.1:8080/hotelvip/adminindex">首页</a>
				</li>
				<li>
					<a>注册界面</a>
				</li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle"><span>基本信息</span></div>

			<ul class="forminfo">
				<li><label>会员编号：</label><input name="id" type="text" class="dfinput" /></li>
				<li><label>用户名：</label><input name="name" type="text" class="dfinput" /></li>
				<li><label>登录密码：</label><input name="password" type="password" class="dfinput" /></li>
				<li><label>确认密码：</label><input name="repassword" type="password" class="dfinput" /></li>
				<li><label>性别：</label><cite><input name="sex" type="radio" value="男" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;<input name="sex" type="radio" value="女" />女</cite></li>
				<li><label>身份证号：</label><input name="idcard" type="text" class="dfinput" /></li>
				<li><label>手机号：</label><input name="tel" type="text" class="dfinput" /></li>
				
				<li><label>&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn" value="注册" />
				</li>
			</ul>

		</div>
	</form>
	</body>

</html>