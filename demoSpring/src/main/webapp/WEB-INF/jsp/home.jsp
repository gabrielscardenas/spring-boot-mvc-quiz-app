<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Home Page</title>
</head>
<body>
    <h1>Welcome, ${username}!</h1>
    <a href="/quiz">Take Quiz</a>
    <a href="/grades">View Grades</a>
    <a href="/logout">Logout</a>
</body>
</html>
