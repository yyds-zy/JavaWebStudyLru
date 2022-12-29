<%--
  Created by IntelliJ IDEA.
  User: v_zyuanxue
  Date: 2022/12/29
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败界面</title>
</head>
<body>
登录失败。<br/>
登录信息是：<br/>
用户名： <%= request.getParameter("username")%> <br/>
密  码： <%=request.getParameter("password")%>  <br/>
<a href="check.jsp">返回登录界面</a>
</body>
</html>
