<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <title>Happy Corporation</title>
</head>


<body>

<h1>All Employees</h1>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
    </tr>
    <c:forEach var="e" items="${allEmployees}">
        <tr>
            <td>${e.name}</td>
            <td>${e.surname}</td>
            <td>${e.department}</td>
            <td>${e.salary}</td>
        </tr>
    </c:forEach>
</table>
<br>

<h2><a href="/edit">edit page</a></h2>

</body>

</html>