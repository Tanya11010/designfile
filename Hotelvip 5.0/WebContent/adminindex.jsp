<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//获取的是网站的名称
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//http://127.0.0.1:8080/rolesys/
%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="static/js/jquery.js"></script>
<%
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	String date = format.format(new Date());
%>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a>首页</a></li>
		</ul>
	</div>

	<div class="mainindex">


		<div class="welinfo">
			<span><img src="static/images/sun.png" alt="天气" /></span> <b>Admin-欢迎使用酒店会员管理系统</b>
		</div>

		<div class="welinfo">
			<span><img src="static/images/time.png" alt="时间" /></span> <i>您本次登录的时间：<%=date%></i>
		</div>

		<div class="xline"></div>

		<ul class="iconlist">

			<li><img src="static/images/ico01.png" />
			<p>
					<a
						href="http://127.0.0.1:8080/hotelvip/adminservlet?type=showgood&pageindex=1"
						target="rightFrame">商品管理</a>
				</p></li>
			<li><img src="static/images/ico02.png" />
			<p>
					<a href="http://127.0.0.1:8080/hotelvip/adminservlet?type=register"
						target="rightFrame">添加会员</a>
				</p></li>
			<li><img src="static/images/ico04.png" />
			<p>
					<a href="http://127.0.0.1:8080/hotelvip/adminservlet?type=select"
						target="rightFrame">充值</a>
				</p></li>
			<li><img src="static/images/ico05.png" />
			<p>
					<a
						href="http://127.0.0.1:8080/hotelvip/adminservlet?type=queryroom&pageindex=1"
						target="rightFrame">房间管理</a>
				</p></li>
			<li><img src="static/images/ico06.png" />
			<p>
					<a
						href="http://127.0.0.1:8080/hotelvip/adminservlet?type=showuser&pageindex=1"
						target="rightFrame">查询会员</a>
				</p></li>

		</ul>

		<div class="xline"></div>
		<div class="box"></div>


	</div>


</body>
</html>