<%--
  Created by IntelliJ IDEA.
  User: rbk
  Date: 7/1/25
  Time: 6:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Title</title>
</head>
<body>
    <div> Category name : ${requestScope.category.name}</div>
    <div> Category description : ${requestScope.category.description}</div>
    <c:forEach var="p" items="${requestScope.category.products}">
        <div>
            <div>Product Name:${p.name}</div>
            <div>Product description:${p.productDesc}</div>
            <div>Product quantity:${p.price}</div>
            <div>Product manufacturing date:${p.manufactureDate}</div>
            <div>Product price:${p.availableQuantity}</div>
        </div>

    </c:forEach>

</body>
</html>
