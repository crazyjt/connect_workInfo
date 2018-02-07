<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/registerServlet" method="post">
		员工id：<input type="text" name="w_id" value="${validateErr.w_id }"/>${validateErr.validateMsg.w_id } ${existErr }<br/>
		员工密码：<input type="password" name="w_password"/>${validateErr.validateMsg.w_password }<br/>
		确认密码：<input type="password" name="w_repassword"/>${validateErr.validateMsg.w_repassword }<br/>
		员工姓名：<input type="text" name="w_name" value="${validateErr.w_name }"/>${validateErr.validateMsg.w_name }<br/>
		员工岗位：<input type="text" name="w_type" value="${validateErr.w_type }"/>${validateErr.validateMsg.w_type }<br/>
		员工性别：<input type="radio" name="w_sex" value="男" checked="checked"/>男
				<input type="radio" name="w_sex" value="女"/>女<br/>
		员工工龄：<input type="text" name="w_workTime"/><br/>
		<input type="submit" value="注册"/><br/>
	</form>
</body>
</html>