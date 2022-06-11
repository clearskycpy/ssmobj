<%--
  Created by IntelliJ IDEA.
  User: 小宇
  Date: 2022/4/26
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<br>
<a href="${pageContext.request.contextPath}/demo.action">zhuddddddddddddddd</a>
<br>
测试不同请求的提交方式
<form action="${pageContext.request.contextPath}/req.action" method="get">
    <input type="submit" value="提交">
</form>
<br>
<h2>1.单个数据的提交</h2>
<form action="${pageContext.request.contextPath}/one.action" method="get">
    姓名<input name="myname"><br>
    年龄<input name="age"><br>
    <input type="submit" value="提交">
</form>
<br>
<br>
<h2>Object to </h2>
<form action="${pageContext.request.contextPath}/two.action" method="get">
    姓名<input name="name"><br>
    年龄<input name="age"><br>
    <input type="submit" value="提交">
</form>
<br>
<h2>第三种提交方式 动态占位符提交</h2>
<a href="${pageContext.request.contextPath}/three/张三/22.action">动态提交</a>
<h4>第四种提交数据的方式，参数名称不一致解决方案</h4><br>
<form action="${pageContext.request.contextPath}/four.action" method="post">
    姓名<input name="name"><br>
    年龄<input name="age"><br>
    http://localhost:8080/spring/index.jsp
    <input type="submit" value="提交">
</form>
</body>

</html>
