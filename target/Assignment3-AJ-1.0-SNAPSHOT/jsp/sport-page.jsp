<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 9/13/2020
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="boostrap.jsp"%>
</head>
<body>
<!--scriplet -->
<%! public String img_url(String img_url){
    return img_url;
}
%>
<!--scriplet -->
<%@include file="header.jsp"%>
<form action="${pageContext.servletContext.contextPath}/cart" method="get" style="margin: auto; width: 30%; margin-top: 5%">
    <input type="hidden" name="action" value="add">
    <input type="hidden" name="sport" value="Fifa">
    <img class="img-thumbnail" src="<%= img_url("https://static.gabestore.ru/product/qIsGBMM1sozVnx5mYGwJrCvULKDV5wX-.jpg")%>"><br>
    <button class="btn btn-primary" type="submit" style="margin-top: 5%;width: 100%;margin-bottom: 5%">add to cart</button>
</form>
<form action="${pageContext.servletContext.contextPath}/cart" method="get" style="margin: auto; width: 30%; margin-top: 10%">
    <input type="hidden" name="action" value="add">
    <input type="hidden" name="sport" value="NFL">
    <img class="img-thumbnail" src="<%= img_url("https://static.gabestore.ru/product/LRJJXi_Qo-xT9sw5KZoeynbBi8_DUiev.jpg")%>"><br>
    <button class="btn btn-primary" type="submit" style="margin-top: 5%;width: 100%;margin-bottom: 5%">add to cart</button>
</form>
<form action="${pageContext.servletContext.contextPath}/cart" method="get" style="margin: auto; width: 30%; margin-top: 10%">
    <input type="hidden" name="action" value="add">
    <input type="hidden" name="sport" value="NBA">
    <img class="img-thumbnail" src="<%= img_url("https://static.gabestore.ru/product/0msaHlDTYwfKjQFY6qy8GPIfwZRwbGFm.jpg")%>"><br>
    <button class="btn btn-primary" type="submit" style="margin-top: 5%;width: 100%;margin-bottom: 5%">add to cart</button>
</form>

<form action="${pageContext.servletContext.contextPath}/cart" method="get" style="margin: auto; width: 30%; margin-top: 10%">
   <button class="btn btn-primary" type="submit" style="margin-top: 5%;width: 100%;margin-bottom: 5%">pay</button>
</form>
</body>
</html>
