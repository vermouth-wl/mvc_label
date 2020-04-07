<%--
  Created by IntelliJ IDEA.
  User: q1591
  Date: 2020-04-04
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>select标签测试</title>
</head>
<body>
    <h3>fm:select标签添加fm:option标签</h3>
    <fm:form action="select" method="post" modelAttribute="user">
        部门:
        <fm:select path="deptid">
            <fm:option value="1">java 学院</fm:option>
            <fm:option value="2">python 学院</fm:option>
            <fm:option value="3">c++ 学院</fm:option>
            <fm:option value="4">c 学院</fm:option>
            <fm:option value="5">go 学院</fm:option>
            <fm:option value="6">php 学院</fm:option>
            <fm:option value="7">object c 学院</fm:option>
            <fm:option value="8">swift 学院</fm:option>
        </fm:select>
    </fm:form>
</body>
</html>
