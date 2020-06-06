<%@ page import="com.films.search.advansed.diploma.database.model.Tag" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: igorh
  Date: 06.06.2020
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="fragments/head.jsp" %>
<%--<head>--%>
<%--    <title>The Materialize Selects Example</title>--%>
<%--    <meta name = "viewport" content = "width = device-width, initial-scale = 1">--%>
<%--    <link rel = "stylesheet"--%>
<%--          href = "https://fonts.googleapis.com/icon?family=Material+Icons">--%>
<%--    <link rel = "stylesheet"--%>
<%--          href = "https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">--%>
<%--    <script type = "text/javascript"--%>
<%--            src = "https://code.jquery.com/jquery-2.1.1.min.js"></script>--%>
<%--    <script src = "https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">--%>
<%--    </script>--%>

<%--    <script>--%>
<%--      $(document).ready(function() {--%>
<%--        $('select').material_select();--%>
<%--      });--%>
<%--    </script>--%>
<%--</head>--%>
<body>
<div class="tagSelectorContainer">
    <label>Choose a tags:</label>
    <div class="tagSelector">
        <select name= "name" multiple>
            <%
                Map<Tag, String> tagsMap = (HashMap<Tag, String>) request
                        .getAttribute("tagsMap");
                for (Tag tag : Tag.values()) {%>
            <option value="<%=tag.toString()%>"><%=tagsMap.get(tag)%>
            </option>
            <%}%>
        </select>
    </div>
</div>
</body>
</html>
