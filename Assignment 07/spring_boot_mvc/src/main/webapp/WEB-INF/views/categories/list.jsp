<%--
  Created by IntelliJ IDEA.
  User: rbk
  Date: 6/29/25
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
</head>
<body>
<%--<h5>List - ${requestScope.categoryList}</h5>--%>
<h2 class="display-4 mb-3">List of all Categories</h2>

<h3 class="display-5 mt-3">${requestScope.message}</h3>
<table class="table table-bordered">
  <thead>
    <tr>
      <th>Category id</th>
      <th>Category name</th>
      <th>Category description</th>
      <th>Update</th>
      <th>Delete</th>
    </tr>
  </thead>
  <c:forEach var="category" items="${requestScope.categoryList}">
    <tr>
      <td>${category.id}</td>
      <c:url var="url" value="/categories/display?id=${category.id}"/>
      <td><a href = "${url}">${category.name}</a></td>
      <td>${category.description}</td>
      <c:url var = "url" value="/categories/update"/>
      <td><a href = "${url}?id=${category.id}" class="btn btn-success">Update</a></td>
      <c:url var = "url" value="/categories/delete"/>
      <td><a href = "${url}?id=${category.id}" class="btn btn-warning">Delete</a></td>
    </tr>
  </c:forEach>
</table>
<c:url var = "url" value="/categories/addform"/>
<p class="text-center mt-5" ><a href="${url}">Add new Category</a></p>


<h3>

</h3>
</body>
</html>
