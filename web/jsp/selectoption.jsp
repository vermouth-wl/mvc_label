<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: q1591
  Date: 2020-04-05
  Time: 01:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>select标签测试</title>
</head>
<body>
    <h3>fm:select标签item属性绑定Map</h3>
    <fm:form modelAttribute="user" action="selectoption" method="post">
<%--        部门: <fm:select path="deptid">--%>
<%--        <fm:options items="${deptParentMap}"/>--%>
<%--    </fm:select>--%>
        部门: <fm:select path="deptid" items="${deptMap}"/>
    </fm:form>
</body>
</html>
