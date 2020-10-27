<%@ page import="java.util.Map" %>
<%@ page import="kz.edu.astanait.Sport.Sport" %>
<%@ page import="java.util.Queue" %><%--
  Created by IntelliJ IDEA.
  User: super
  Date: 10/19/2020
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" style="margin: auto; width: 30%; margin-top: 5%">
    <tr>
        <th>Username</th>
        <th>Price</th>
    </tr>

        <tr>
            <td><%HttpSession session1 = request.getSession();%><%=session1.getAttribute("user")%></td>
            <td><%
                Map<String, Sport> cart = (Map<String, Sport>) session1.getAttribute("cart");
                int total = 0;
                for (Sport cart1: cart.values()){
                    total += cart1.price();
                }
            %>
                <%=total%> $</td>
        </tr>
</table>
</body>
</html>
