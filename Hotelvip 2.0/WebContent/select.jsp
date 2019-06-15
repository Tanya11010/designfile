<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();//获取的是网站的名称
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//http://127.0.0.1:8080/rolesys/  
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
	<form action="<%=request.getContextPath() %>/selectuser" method="post" >
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="http://127.0.0.1:8080/hotelvip/adminindex">首页</a></li>
    <li><a>充值中心</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>查询信息</span></div>
    
    <ul class="forminfo">
    <li><label>会员编号：</label><input name="id" type="text" class="dfinput" /></li>
    <li><label>用户名：</label><input name="name" type="text" class="dfinput" /></li>
    <li><label>&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input name="" type="submit" class="btn" value="查询"/>
    </li>
    </ul>
    
    
    </div>

</form>
</body>

</html>