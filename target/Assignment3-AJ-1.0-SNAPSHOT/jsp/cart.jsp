<%@ page import="kz.edu.astanait.Sport.Sport" %>
<%@ page import="java.util.Map" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" style="margin: auto; width: 30%; margin-top: 5%">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Total Price</th>
    </tr>

<c:forEach var="cart" items="${sessionScope.cart}">
    <tr>
        <td>${cart.value.name()}</td>
        <td>${cart.value.price()} $</td>
        <%HttpSession session1 = request.getSession();%>
        <td><%
            Map<String, Sport> cart = (Map<String, Sport>) session1.getAttribute("cart");
            int total = 0;
            for (Sport cart1: cart.values()){
                total += cart1.price();
            }
        %>
            <%=total%> $</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
