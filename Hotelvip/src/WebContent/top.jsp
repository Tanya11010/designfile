<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//获取的是网站的名称
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	$(function() {
		//顶部导航切换
		$(".nav li a").click(function() {
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		})
	})
</script>



</head>

<body style="background: url(static/images/topbg.gif) repeat-x;">

	<div class="topright">
		<ul>
		<li><div id="time" style="color: white;">
				当前时间：
				<script>
				document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());
				setInterval("document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
				</script>
			</div></li>
			<li><a href="http://127.0.0.1:8080/hotelvip/user/login"
				target="_parent">退出</a></li>
			
		</ul>
		
	</div>

</body>
</html>
