<%--
  Created by IntelliJ IDEA.
  User: q1591
  Date: 2020-04-04
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>radiobutton测试</title>
</head>
<body>
    <h3>fm:radiobutton标签测试</h3>
    <fm:form modelAttribute="user" method="post" action="radiobutton">
        性别:
        <fm:radiobutton path="sex" value="男"/>男 &nbsp;
        <fm:radiobutton path="sex" value="女"/>女 &nbsp;
    </fm:form>
</body>
</html>
