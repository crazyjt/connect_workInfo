<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/myStyle.css" type="text/css" rel="stylesheet">
</head>
<body>
${errMsg }
	<form action="${pageContext.request.contextPath}/loginServlet" method="post">
		员工id：<input type="text" name="w_id" value="${workerBack.w_id }"/><br/>
		员工密码：<input type="password" name="w_password"/><br/>
		验证码：<input class="codeInput" type="text" name="code"/> 
			  <img class="code" src="${pageContext.request.contextPath}/veritifyCodeServlet"/>
			  <!-- href=""刷新当前页面 -->
			  <a href="">看不清，换一张</a>
			  <br/> 
		${codeErr }<br/>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>