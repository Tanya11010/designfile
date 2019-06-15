<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%
	String path = request.getContextPath();//获取的是网站的名称
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
</head>

<body>
	<form action="<%=request.getContextPath()%>/addmoney" method="post">
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="http://127.0.0.1:8080/hotelvip/adminindex">首页</a>
				</li>
				<li><a>充值界面</a></li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle">
				<span>充值信息</span>
			</div>

			<ul class="forminfo">
				<li><label>会员编号：</label><input name="userid" type="text"
					class="dfinput" /></li>
				<li><label>会员名：</label><input name="username" type="text"
					class="dfinput" /></li>
				<li><label>充值金额：</label><input name="addmoney" type="text"
					class="dfinput" /></li>

				<li><label>&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="submit" class="btn" value="充值" /></li>
			</ul>

		</div>
	</form>
</body>

</html>