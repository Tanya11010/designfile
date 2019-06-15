<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="cn.lut.hotelvip.domain.po.Customer"%>
<%
String path = request.getContextPath();//获取的是网站的名称
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="static/js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>
   <body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="http://127.0.0.1:8080/hotelvip/adminindex">首页</a></li>
    <li><a>基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
      </ul>
       
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>会员编号</th>
        <th>会员名称</th>
        <th>会员余额</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
      <%
      
      Customer cust = (Customer)request.getAttribute("cust");
      
      %>
		<tr>
			<td><%=cust.getUserid() %></td>
			<td><%=cust.getUsername()%></td>
			<td><%=cust.getUsermoney()%></td>
			<td><a
			href='<%=request.getContextPath() %>/adminservlet?goodid=<%=cust.getUserid()%>&type=addmoney '>充值</a></td>
		</tr>
	</table>
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>
</html>