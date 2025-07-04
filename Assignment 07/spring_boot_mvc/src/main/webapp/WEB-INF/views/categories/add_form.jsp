<%--
  Created by IntelliJ IDEA.
  User: rbk
  Date: 6/30/25
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
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
