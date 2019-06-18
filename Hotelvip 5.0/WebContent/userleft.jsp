<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();//获取的是网站的名称
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//http://127.0.0.1:8080/rolesys/  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="static/js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>后台管理系统</div>
    
    <dl class="leftmenu">
        
    
    <dd><div class="title"><span><img src="static/images/leftico03.png" /></span>查询消费记录</div>
    <ul class="menuson">
        <li><cite></cite><a href="http://127.0.0.1:8080/hotelvip/customerservlet?type=query" target="rightFrame">查询消费记录</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="static/images/leftico04.png" /></span>积分兑换</div>
    <ul class="menuson">
        <li><cite></cite><a href="http://127.0.0.1:8080/hotelvip/customerservlet?type=querygood" target="rightFrame">积分兑换</a><i></i></li>
    </ul>
    
    </dd>   
    
    </dl>
    
</body>
</html>
