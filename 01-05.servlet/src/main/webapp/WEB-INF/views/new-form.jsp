<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--코드 재호라용하기 위해 상대 경로 사용, [현재 URL이 속한 계층 경로 + /save] --%>
<%--이렇게 /(슬래쉬) 없이 쓰면 알아서 [현재 경로 + /save]로 된다. 보통은 절대경로로 해주는게 좋음 --%>
<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>
