<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Grades Page</title>
</head>
<body>
    <h2>Grades</h2>
    <table>
        <thead>
            <tr>
                <th>Username</th>
                <th>Score</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="entry" items="${grades}">
                <tr>
                    <td>${entry.key}</td>
                    <td>${entry.value}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
