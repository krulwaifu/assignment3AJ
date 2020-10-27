<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <%@ include file="boostrap.jsp"%>
</head>
<body>
<!--scriplet -->
<%! public String img_url(String img_url){
    return img_url;
}
%>
<!--scriplet -->
<!--includes header's code from header.jsp -->
<%@include file="header.jsp"%>
<form action="${pageContext.request.contextPath}/Servlet" method="get" style="margin: auto; width: 30%; margin-top: 5%">
    <input type="hidden" name="genre" value="Sport Games">
    <img class="img-thumbnail" src="<%= img_url("https://static.gabestore.ru/product/0msaHlDTYwfKjQFY6qy8GPIfwZRwbGFm.jpg")%>"><br>
    <button class="btn btn-primary" type="submit" style="margin-top: 5%;width: 100%">Sport Games</button>
</form>
<form action="${pageContext.request.contextPath}/Servlet" method="get"  style="margin: auto; width: 30%; margin-top: 10%">
    <input type="hidden" name="genre" value="Racing Games">
    <img class="img-thumbnail" src="<%= img_url("https://static.gabestore.ru/product/waMf_uxHcAqcmGzm1vEagwhLTfACK3kP.jpg")%>"><br>
    <button class="btn btn-primary" type="submit" style="margin-top: 5%;width: 100%">Racing Games</button>
</form>
<form action="${pageContext.request.contextPath}/Servlet" method="get"  style="margin: auto; width: 30%; margin-top: 10%">
    <input type="hidden" name="genre" value="RPG Games">
    <img class="img-thumbnail" src="<%= img_url("https://static.gabestore.ru/product/6GWqttg2TfPsWSnjwz_1k96aXLS7JDO5.jpg")%>"><br>
    <button class="btn btn-primary" type="submit" style="margin-top: 5%;width: 100%;margin-bottom: 5%">RPG Games</button>
</form>
<!--includes footer's code from footer.jsp -->

</body>
</html>
