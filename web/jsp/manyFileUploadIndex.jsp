<%--
  Created by IntelliJ IDEA.
  User: q1591
  Date: 2020-04-15
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>多文件上传页</title>
</head>
<body>
    <h3>多文件上传</h3>
    <form action="../manyFileUpload" method="post" enctype="multipart/form-data">
        文件描述: <input type="text" name="desc"/><br>
        选择文件: <input type="file" name="files" multiple="multiple"/><br>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
