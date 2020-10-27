<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
        out.print(" <h1> " + cookies[i].getName( ) + ":<br> ");
        out.print(cookies[i].getValue( )+" </h1> ");
    }
%>
</body>
</html>
