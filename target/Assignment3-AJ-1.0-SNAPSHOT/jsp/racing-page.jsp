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
<!--includes header's code from header.jsp -->
<form action="${pageContext.request.contextPath}/Servlet3" method="get" style="margin: auto; width: 30%; margin-top: 5%">
    <input type="hidden" name="racing" value="Assetto Corsa">
    <img class="img-thumbnail" src="<%= img_url("https://static.gabestore.ru/product/t2u2ojDvqdSQHQi2OCfW_04vX4Hq6SUj.jpg")%>"><br>
    <button class="btn btn-primary" type="submit" style="margin-top: 5%;width: 100%">add to cart</button>
</form>
<form action="${pageContext.request.contextPath}/Servlet3" method="get"  style="margin: auto; width: 30%; margin-top: 10%">
    <input type="hidden" name="racing" value="Need for Speed">
    <img class="img-thumbnail" src="<%= img_url("https://static.gabestore.ru/product/waMf_uxHcAqcmGzm1vEagwhLTfACK3kP.jpg")%>"><br>
    <button class="btn btn-primary" type="submit" style="margin-top: 5%;width: 100%">add to cart</button>
</form>
<form action="${pageContext.request.contextPath}/Servlet3" method="get"  style="margin: auto; width: 30%; margin-top: 10%">
    <input type="hidden" name="racing" value="Project Cars 2">
    <img class="img-thumbnail" src="<%= img_url("https://static.gabestore.ru/product/Mgfd77rTjlE0fXYUEjyL3ekzCvAfJtGo.jpg")%>"><br>
    <button class="btn btn-primary" type="submit" style="margin-top: 5%;width: 100%;margin-bottom: 5%">add to cart</button>
</form>
<form action="${pageContext.request.contextPath}/Servlet3" method="get"  style="margin: auto; width: 30%; margin-top: 10%">
<button class="btn btn-primary" type="submit" style="margin-top: 5%;width: 100%;margin-bottom: 5%">pay</button>
</form>
<!--includes footer's code from footer.jsp -->
</body>
</html>
