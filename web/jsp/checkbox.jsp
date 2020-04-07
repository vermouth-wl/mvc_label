<%--
  Created by IntelliJ IDEA.
  User: q1591
  Date: 2020-04-03
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>课程选择</title>
</head>
<body>
    <h3>fm标签测试</h3>
    <fm:form method="post" action="checkbox" modelAttribute="cources">
        <fm:checkbox path="cources" value="python web" label="python"/>&nbsp;
        <fm:checkbox path="cources" value="java web" label="java"/>&nbsp;
        <fm:checkbox path="cources" value="C#" label="C#"/>&nbsp;
        <fm:checkbox path="cources" value="Go" label="Golang"/>&nbsp;
        <fm:checkbox path="reader" value="true"/>
    </fm:form>
</body>
</html>
