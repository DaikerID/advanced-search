<%@ page import="com.films.search.advansed.diploma.LocalDateTimeUtils" %>
<%@ page import="com.films.search.advansed.diploma.database.model.Genre" %>
<%@ page import="com.films.search.advansed.diploma.database.model.Movie" %>
<%@ page import="com.films.search.advansed.diploma.database.model.Profile" %>
<%@ page import="com.films.search.advansed.diploma.database.model.Tag" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.Month" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<%@ include file="fragments/head.jsp" %>
<body>
<%@ include file="fragments/header.jsp" %>
<div>
    <form action="/search">
        <h2>Search</h2>
        <p><input type="search" name="searchLine" placeholder="Find movie" required>
            <input type="submit" value="Search"></p>
    </form>
    <form action="/advanced-search">
        <h2>Advanced search</h2>
        <p><input type="search" name="movieName" placeholder="movieName">
        <p><input type="search" name="actorsName" placeholder="actorsName">
        <p><input type="search" name="directorsName" placeholder="directorsName">
        <p><input type="search" name="producersName" placeholder="producersName">
        <p><input type="search" name="countries" placeholder="countries">


        <p><label>Choose a tags:</label>
            <select name="tags">
                <%
                    Map<Tag, String> tagsMap = (HashMap<Tag, String>) request
                            .getAttribute("tagsMap");
                    for (Tag tag : Tag.values()) {%>
                <option value="<%=tag.toString()%>"><%=tagsMap.get(tag)%>
                </option>
                <%}%>
            </select>


        <p><label>Choose a genre:</label>
            <select name="genres">
                <%
                    Map<Genre, String> genresMap = (HashMap<Genre, String>) request
                            .getAttribute("genresMap");
                    for (Genre genre : Genre.values()) {%>
                <option value="<%=genre.toString()%>"><%=genresMap.get(genre)%>
                </option>
                <%}%>
            </select>


        <p><label>Choose a begining of release date interval:</label>
            <select name="releaseDayStart">
                <option value="-"> -</option>
                <% for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"><%=i%>
                </option>
                <%}%>
            </select>

            <select name="releaseMonthStart">
                <option value="-"> -</option>
                <%
                    Map<Month, String> monthsMap = (HashMap<Month, String>) request
                            .getAttribute("monthsMap");
                    for (Month month : Month.values()) {%>
                <option value="<%=month.toString()%>"><%=monthsMap.get(month)%>
                </option>
                <%}%>
            </select>

            <select name="releaseYearStart">
                <option value="-"> -</option>
                <% int firstFilmYear = LocalDateTimeUtils.FIRST_FILM_DATE.getYear();
                    for (int i = LocalDate.now().getYear(); i >= firstFilmYear; i--) {%>
                <option value="<%=i%>"><%=i%>
                </option>
                <%}%>
            </select>

        <p><label>Choose a ending of release date interval:</label>
            <select name="releaseDayEnd">
                <option value="-"> -</option>
                <% for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"><%=i%>
                </option>
                <%}%>
            </select>
            <select name="releaseMonthEnd">
                <option value="-"> -</option>
                <% for (Month month : Month.values()) {%>
                <option value="<%=month.toString()%>"><%=monthsMap.get(month)%>
                </option>
                <%}%>
            </select>
            <select name="releaseYearEnd">
                <option value="-"> -</option>
                <% for (int i = LocalDate.now().getYear(); i >= firstFilmYear; i--) {%>
                <option value="<%=i%>"><%=i%>
                </option>
                <%}%>
            </select>

        <p><input type="submit" value="Search"></p>
    </form>
</div>
<div class="results">
    <div>
        <% List<Movie> movies = (List<Movie>) request.getAttribute("movies");
            if (movies.size() > 0) {%>
        <h2>Movies</h2>
        <table>
            <thead>
            <tr>
                <th>#</th>
                <th>Movie Name</th>
                <th>Year</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <% for (Movie movie : movies) {%>
            <tr>
                <td><%=movies.indexOf(movie) + 1%>
                </td>
                <td><%=movie.getName()%>
                </td>
                <td><%=movie.getPremierDate().getYear()%>
                </td>
                <td>
                    <a href="/movie/?movieId=<%=movie.getId()%>">Movie Page</a>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
        <%}%>
    </div>

    <div>
        <%
            List<Profile> profiles = (List<Profile>) request.getAttribute("profiles");
            if (profiles.size() > 0) {%>
        <h2>Profiles</h2>
        <table>
            <thead>
            <tr>
                <th>#</th>
                <th>Profile</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <% for (Profile profile : profiles) {%>
            <tr>
                <td><%=profiles.indexOf(profile) + 1%>
                </td>
                <td><%=profile.getName().concat(" ").concat(profile.getSurname())%>
                </td>
                <td>
                    <a href="/profile/?profileId=<%=profile.getId()%>">Profile Page</a>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
        <%
            }
        %>
    </div>
</div>
</body>
</html>