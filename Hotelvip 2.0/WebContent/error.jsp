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
		<script type="text/javascript" src="static/js/jquery.js"></script>

		<script language="javascript">
			$(function() {
				$('.error').css({
					'position': 'absolute',
					'left': ($(window).width() - 490) / 2
				});
				$(window).resize(function() {
					$('.error').css({
						'position': 'absolute',
						'left': ($(window).width() - 490) / 2
					});
				})
			});
		</script>

	</head>

	<body style="background:#edf6fa;">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="http://127.0.0.1:8080/hotelvip/adminindex">首页</a></li>
    <li><a>注册失败</a></li>
    </ul>
    </div>
    
    <div class="error">
    
    <h2>非常遗憾，注册失败！</h2>
    <p>看到这个提示，就自认倒霉吧!</p>
    <div class="reindex"><a href="http://127.0.0.1:8080/hotelvip/adminservlet?type=register" target="rightFrame">返回首页</a></div>
    
    </div>


</body>

</html>