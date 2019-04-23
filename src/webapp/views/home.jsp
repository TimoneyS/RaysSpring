<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="home.title"/></title>
</head>
<body>
    <s:url value="/question" var="questionUrl"/>
    <s:url value="/user" var="userUrl"/>

    <a href="${userUrl }/reg">注册</a> <a href="question/create">提问</a>
<hr>

    <a href="${questionUrl }/123">First Question</a>
</body>
</html>