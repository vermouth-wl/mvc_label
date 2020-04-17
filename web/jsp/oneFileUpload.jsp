<%--
  Created by IntelliJ IDEA.
  User: q1591
  Date: 2020-04-15
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>单文件上传</title>
</head>
<body>
    <form action="../oneFileUpload" method="post" enctype="multipart/form-data">
        选择文件: <input type="file" name = "file"/><br>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
