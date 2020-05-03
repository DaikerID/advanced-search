<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
<h1>${message}</h1>
<h2>Load time - <%=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yy HH:mm"))%>
</h2>

<h2>search row - ${search}</h2>
<form action="/search">
    <p><input type="search" name="searchLine" placeholder="Find movie">
        <input type="submit" value="Search"></p>
</form>
</body>
</html>
