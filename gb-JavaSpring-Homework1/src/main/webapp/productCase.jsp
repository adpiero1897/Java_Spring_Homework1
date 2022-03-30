<%@ page import="Goods.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language = "java" %>
<html>
<head>
    <title>productCase</title>
</head>
<body>
<h1>We collect for you such productCase:</h1>
<hr>
<ul>
    <% for (Product product: (ArrayList<Product>)request.getAttribute("productCase")) { %>
    <li>title: <%=product.getTitle()%>; price: <%=product.getCost()%> </li>
   <%}%>
</ul>
</body>
</html>