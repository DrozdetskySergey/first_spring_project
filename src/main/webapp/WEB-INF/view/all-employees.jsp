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
        <th>Operations</th>
    </tr>

    <c:forEach var="e" items="${allEmployees}">
        <c:url var="editButton" value="/editEmployee">
            <c:param name="employeeId" value="${e.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="employeeId" value="${e.id}"/>
        </c:url>

        <tr>
            <td>${e.name}</td>
            <td>${e.surname}</td>
            <td>${e.department}</td>
            <td>${e.salary}</td>
            <td>
                <input type="button" value="Edit" onclick="window.location.href='${editButton}'"/>
                <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>

</table>
<br>

<input type="button" value="Add" onclick="window.location.href='addNewEmployee'"/>

</body>

</html>