<%--
  Created by IntelliJ IDEA.
  User: rbk
  Date: 7/1/25
  Time: 6:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form:form method="post" modelAttribute="category">
        <table class="form-group">
            <tr>
                <td>Category Name</td>

                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><form:textarea path="description"/></td>
            </tr>
            <tr>
                <td><input class="btn btn-primary" type="submit" value="Add category details"/></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
