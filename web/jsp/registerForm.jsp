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
    <fm:form action="register" method="post" modelAttribute="user">
        <!-- input标签作用, 绑定表单数据 -->
        姓名: <fm:input path="name"/><br>
        <font color="red"><fm:errors path="name"/></font><br>
        性别: <fm:input path="sex"/><br>
        <font color="red"><fm:errors path="sex"/></font><br>
        年龄: <fm:input path="age"/><br>
        <font color="red"><fm:errors path="age"/></font><br>
        密码: <fm:password path="password"/><br>
        介绍: <fm:textarea path="introduce" rows="5" cols="20"/><br>
        <input type="submit" value="注册">
    </fm:form>
</body>
</html>
