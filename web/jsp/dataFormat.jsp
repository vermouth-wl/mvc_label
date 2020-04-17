<%--
  Created by IntelliJ IDEA.
  User: q1591
  Date: 2020-04-13
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>利用conversionservice进行类型转换</title>
</head>
<body>
    <h3>利用conversionservice进行类型的转换</h3>
    <form action="../dataFormat" method="post">
        姓名: <input name="name" type="text"/><br>
        生日: <input name="birthday" type="date"/><br>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
