<%@ page import="java.util.Set" %>
<%@ page import="kz.edu.astanait.RPG.RPG" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="boostrap.jsp"%>
</head>
<body>
<table border="1" style="margin: auto; width: 30%; margin-top: 5%">
    <tr>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach var="cart2" items="${sessionScope.cart2 }">
        <tr>
            <td>${cart2.name()}</td>
            <td>${cart2.price() } $</td>
        </tr>
    </c:forEach>
    <%HttpSession session1 = request.getSession();%>
    <td><%
        Set<RPG> cart = (Set<RPG>) session1.getAttribute("cart2");
        int total = 0;
        for (RPG cart1: cart){
            total += cart1.price();
        }
    %>
        <%=total%> $</td>
</table>
</body>
</html>
