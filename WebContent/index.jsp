<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty worker }">
		<a href="login.jsp">登录</a>
		<a href="register.jsp">注册</a>
	</c:if>
	<c:if test="${not empty worker }">
		<h3>欢迎您,</h3>
		${worker.w_name } <a href="${pageContext.request.contextPath }/loginOutServlet">注销</a>
	</c:if>
</body>
</html>