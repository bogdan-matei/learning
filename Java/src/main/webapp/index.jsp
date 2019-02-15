<%@ page import="general.StorageItem" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <Title>WarriorBackpack</Title>
</head>

<body>

<form action="/FrontServlet" method="post">
    Enter the name of the sword: <input type="text" name="itemName" value="itemName">
    <input type="submit" value="Submit">
</form>


<c:choose>
    <c:when test="${not empty requestScope.itemList}">
    <table>
        <c:forEach items="${requestScope.itemList}" var="item">
            <tr>
                <td>${item.getName()}</td>
            </tr>
        </c:forEach>
    </table>
    </c:when>
    <c:otherwise>
        <h2>There are currently no items</h2>
    </c:otherwise>
</c:choose>

</body>
</html>