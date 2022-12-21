<%--맨 위 첫 줄은 해당 문서가 JSP문서입니다. 라는 것을 의미하는 줄이다.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%----%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/jsp/members/save.jsp" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>