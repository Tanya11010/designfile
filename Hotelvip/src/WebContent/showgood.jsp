<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="cn.lut.hotelvip.domain.po.Good"%>
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
        <li><span><a href='<%=request.getContextPath() %>/adminservlet?type=addgood' target="rightFrame">添加</a></span></li>
        </ul>
    	<ul class="toolbar">
      </ul>
       
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品数量</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
			int pageindex =(int) request.getAttribute("pageindex"); // 页码
			int pagesize = (int) request.getAttribute("pagesize"); // 页的显示条数
			int pagecount = (int) request.getAttribute("pagecount"); // 页的总的张数
			int curpageindex = (int) request.getAttribute("curpageindex"); // 当前页码
			List<Good> listgood =(List<Good>) request.getAttribute("listcustom");
			int index = 1;
			index = (pageindex - 1) * pagesize + 1;
			for (Good cust : listgood) {
		%>
		<tr>
			<td><%=cust.getGoodid() %></td>
			<td><%=cust.getGoodname()%></td>
			<td><%=cust.getGoodprice()%></td>
			<td><%=cust.getGoodnum()%></td>
			<td><a
			href='<%=request.getContextPath() %>/adminservlet?goodid=<%=cust.getGoodid() %>&type=deletegood '>删除</a></td>
		</tr>
		<%
			index++;
			}
		%>
	</table> 


	<div class="pagediv">
		<%
			if (pagecount == 1) {
		%>
		<a href="/hotelvip/adminservlet?type=showgood&pageindex=1">首页</a>
		&nbsp;<a href="/hotelvip/adminservlet?type=showgood&pageindex=1" class="disable"> 上一页</a> &nbsp; <a href="#"
			class="current"><%=curpageindex%> </a> &nbsp;<a href="/hotelvip/adminservlet?type=showgood&pageindex=1"
			class="disable">下一页</a> &nbsp;<a href="/hotelvip/adminservlet?type=showgood&pageindex=1" class="disable"> 尾页</a>
		<%
			} else {
		%>
		<a href="/hotelvip/adminservlet?type=showgood&pageindex=1">首页</a>
		<%
			if (curpageindex - 1 >= 1) {
		%>
		&nbsp;<a href="/hotelvip/adminservlet?type=showgood&pageindex=<%=(curpageindex - 1)%>">上一页</a>
		<%
			} else {
		%>
		&nbsp;<a href="/hotelvip/adminservlet?type=showgood&pageindex=1" class="disable"> 上一页</a>
		<%
			}
		%>
		&nbsp; <a href="#" class="current"> <%=curpageindex%></a>
		<%
			if (curpageindex + 1 <= pagecount) {
		%>
		&nbsp;<a href="/hotelvip/adminservlet?type=showgood&pageindex=<%=(curpageindex + 1)%>">下一页</a>

		<%
			} else {
		%>
		&nbsp;<a href="/hotelvip/adminservlet?type=showgood&pageindex=<%=pagecount%>" class="disable">下一页</a>
		<%
			}
		%>
		&nbsp;<a href="/hotelvip/adminservlet?type=showgood&pageindex=<%=pagecount%>"
			>尾页</a>
		<%
			}
		%>

        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">当前显示第&nbsp;<i class="blue"><%=curpageindex %>&nbsp;</i>页</div>
    </div>
    

    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>
</html>