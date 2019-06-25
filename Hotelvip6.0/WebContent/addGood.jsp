<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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
	</head>

	<body>
	<form action="<%=request.getContextPath() %>/addgood" method="post" >
	
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					<a href="http://127.0.0.1:8080/hotelvip/adminindex">首页</a>
				</li>
				<li>
					<a>添加界面</a>
				</li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle"><span>基本信息</span></div>

			<ul class="forminfo">
				<li><label>商品编号：</label><input name="goodid" type="text" class="dfinput" /></li>
				<li><label>商品名：</label><input name="goodname" type="text" class="dfinput" /></li>
				<li><label>商品价格：</label><input name="goodprice" type="text" class="dfinput" /></li>
				<li><label>商品数量：</label><input name="goodnum" type="text" class="dfinput" /></li>
				
				<li><label>&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn" value="确定" />
				</li>
			</ul>

		</div>
	</form>
	</body>

</html>