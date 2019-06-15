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
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   		 String date= format.format(new Date());
		%>
	</head>
    <body>
	<form action="<%=request.getContextPath() %>/inroom" method="post" >
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					<a href="http://127.0.0.1:8080/hotelvip/adminindex">首页</a>
				</li>
				<li>
					<a>消费界面</a>
				</li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle"><span>消费信息</span></div>

			<ul class="forminfo">
				<li><label>会员编号：</label><input name="userid" type="text" class="dfinput" /></li>
				<li><label>用户名：</label><input name="name" type="text" class="dfinput" /></li>
				<li><label>订房时间：</label><input name="time" type="text" class="dfinput" value="<%=date%>" onclick="JavaScript:this.value=''"/></li>
				<li><label>退房时间：</label><input name="lasttime" type="text" class="dfinput" /></li>
				<li><label>房间编号：</label><input name="roomid" type="text" class="dfinput" /></li>
				<li><label>身份证号：</label><input name="useridcard" type="text" class="dfinput" /></li>
				<li><label>消费金额：</label><input name="usermoney" type="text" class="dfinput" /></li>
				<li><label>所得积分：</label><input name="usergrade" type="text" class="dfinput" /></li>
				<li><label>&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="submit" class="btn" value="开始" />
				</li>
			</ul>

		</div>
	</form>
	</body>
</html>