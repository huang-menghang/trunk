<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>聊天室</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<script type="text/javascript"
	src="<%=basePath%>/static/plugins/jquery/2.1.4/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/static/plugins/socket/1.1.4/sockjs.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/static/plugins/user/talk.js"></script>
</head>
<body>
	<!-- 最外边框 -->
	<div style="margin: 20px auto; border: 1px solid blue; width: 300px; height: 500px;">

	<!-- 消息展示框 -->
    <div id="msg" style="width: 100%; height: 70%; border: 1px solid yellow; overflow: auto;"></div>

		<!-- 消息编辑框 -->
		<textarea id="tx" style="width: 100%; height: 20%;"></textarea>

		<!-- 消息发送按钮 -->
		<button id="TXBTN" style="width: 100%; height: 8%;">发送数据</button>

	</div>
</body>
</html>