<%@ page contentType="text/html;charset=UTF-8"language = "java" %>
<html>
<head>
    <title>productCase</title>
</head>
<body>
<h1>We assemble for you this productCase</h1>
<hr>
<ul>
    <% for (Product product: (ArrayList<Product>)request.getAttribute("productCase")) { %>
    <li>title: <%=product.getTitle()%>; price: <%=product.getCost()%> </li>
   <%}%>
</ul>
</body>
</html>