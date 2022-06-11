<%--
  Created by IntelliJ IDEA.
  User: 小宇
  Date: 2022/4/27
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br>
<br>

<a href="${pageContext.request.contextPath}/one.action">请求转发页面</a><br>
http://localhost:8080/spring_mvc_2_war_exploded/one.cation%7D
<a href="${pageContext.request.contextPath}/two.action">请求转发action</a><br>
<a href="${pageContext.request.contextPath}/three.action">请求转发重定向</a><br>
<a href="${pageContext.request.contextPath}/four.action">重定向action</a><br>
<a href=""> </a>
日期的提交处理
<form action="${pageContext.request.contextPath}/mydate.action">
    日期：<input type="date" name="mydate"><br>
    <input type="submit" value="提交">
</form>
日期的显示处理
</body>
</html>
