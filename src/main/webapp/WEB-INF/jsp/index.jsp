<%@ page import="com.films.search.advansed.diploma.database.model.Genre" %>
<%@ page import="com.films.search.advansed.diploma.database.model.Tag" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.time.Month" %>
<%@ page import="javax.persistence.criteria.CriteriaBuilder.In" %>
<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="fragments/head.jsp" %>
<body>
<%@ include file="fragments/header.jsp" %>
<% if (request.getAttribute("search") != null) {%>
<h2>search row - ${search}</h2>
<%}%>
<form action="/search">
    <p><input type="search" name="searchLine" placeholder="Find movie" required>
        <input type="submit" value="Search"></p>
</form>
<form action="/advanced-search">
    <p><input type="search" name="movieName" placeholder="movieName">
    <p><input type="search" name="actorsName" placeholder="actorsName">
    <p><input type="search" name="directorsName" placeholder="directorsName">
    <p><input type="search" name="producersName" placeholder="producersName">
    <p><input type="search" name="countries" placeholder="countries">
    <p><label for="tags">Choose a tags:</label>
        <select id="tags">
            <%
                Map<Tag, String> tagsMap = (HashMap<Tag, String>) request.getAttribute("tagsMap");
                for (Tag tag : Tag.values()) {%>
            <option value="<%=tag.toString()%>"><%=tagsMap.get(tag)%>
            </option>
            <%}%>
        </select>
    <p><label for="genres">Choose a genre:</label>
        <select id="genres">
            <%
                Map<Genre, String> genresMap = (HashMap<Genre, String>) request
                        .getAttribute("genresMap");
                for (Genre genre : Genre.values()) {%>
            <option value="<%=genre.toString()%>"><%=genresMap.get(genre)%>
            </option>
            <%}%>
        </select>
    <p><label for="releaseDayStart">Choose a begining of release date interval:</label>
        <select id="releaseDayStart">
            <option value="-"> - </option>
            <% for (int i = 1; i <= 31; i++) {%>
            <option value="<%=i%>"><%=i%>
            </option>
            <%}%>
        </select>
        <select id="releaseMonthStart">
            <option value="-"> - </option>
            <%
                Map<Month, String> monthsMap = (HashMap<Month, String>) request
                        .getAttribute("monthsMap");
                for (Month month : Month.values()) {%>
            <option value="<%=month.toString()%>"><%=monthsMap.get(month)%>
            </option>
            <%}%>
        </select>
        <select id="releaseYearStart">
            <option value="-"> - </option>
            <% int firstFilmYear = 1895;
                for (int i = firstFilmYear; i <= LocalDate.now().getYear(); i++) {%>
            <option value="<%=i%>"><%=i%>
            </option>
            <%}%>
        </select>

    <p><label for="releaseDayEnd">Choose a ending of release date interval:</label>
        <select id="releaseDayEnd">
            <option value="-"> - </option>
            <% for (int i = 1; i <= 31; i++) {%>
            <option value="<%=i%>"><%=i%>
            </option>
            <%}%>
        </select>
        <select id="releaseMonthEnd">
            <option value="-"> - </option>
            <% for (Month month : Month.values()) {%>
            <option value="<%=month.toString()%>"><%=monthsMap.get(month)%>
            </option>
            <%}%>
        </select>
        <select id="releaseYearEnd">
            <option value="-"> - </option>
            <% for (int i = firstFilmYear; i <= LocalDate.now().getYear(); i++) {%>
            <option value="<%=i%>"><%=i%>
            </option>
            <%}%>
        </select>

    <p><input type="submit" value="Search"></p>
</form>

</body>
</html>
