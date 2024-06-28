<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Quiz Page</title>
</head>
<body>
    <h2>Quiz</h2>
    <form action="quiz" method="post">
        <label for="score">Enter your score:</label>
        <input type="number" id="score" name="score">
        <button type="submit">Submit</button>
    </form>
</body>
</html>
