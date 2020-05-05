<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="fragments/head.jsp" %>
<body>
<%@ include file="fragments/header.jsp" %>
<h2>search row - ${search}</h2>
<form action="/search">
    <p><input type="search" name="searchLine" placeholder="Find movie" required>
        <input type="submit" value="Search"></p>
</form>
</body>
</html>
