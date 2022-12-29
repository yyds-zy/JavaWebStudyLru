<%--
  Created by IntelliJ IDEA.
  User: v_zyuanxue
  Date: 2022/12/29
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/checkServlet" method="post">
    useName:<input type="text" name="username"/>  <br/>
    passWord:<input type="password" name="password"> <br/>
    <input type="submit" value="Login"/>
    <input type="reset" value="Reset"/>
</form>
</body>
</html>
