<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 24.05.2023
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
    <form action="students" method="GET">
        Номер зачетки: <input type="text" value="" name="transcript_num">
        Оценка: <input type="text" value="" name="grp">
        <button type="submit">Submit</button>
    </form>
</body>
</html>
