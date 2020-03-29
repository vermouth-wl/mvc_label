<%--
  Created by IntelliJ IDEA.
  User: q1591
  Date: 2020-03-29
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <h3>用户注册</h3>
    <fm:form action="register" method="post">
        <!-- input标签作用, 绑定表单数据 -->
        姓名: <fm:input path="name"/><br>
        性别: <fm:input path="sex"/><br>
        年龄: <fm:input path="age"/><br>
    </fm:form>
</body>
</html>
