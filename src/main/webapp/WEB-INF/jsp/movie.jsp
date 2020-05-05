<%@ page import="com.films.search.advansed.diploma.database.model.Genre" %>
<%@ page import="com.films.search.advansed.diploma.database.model.Movie" %>
<%@ page import="com.films.search.advansed.diploma.database.model.Profile" %>
<%@ page import="com.films.search.advansed.diploma.database.model.Tag" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="fragments/head.jsp" %>
<body>
<%@ include file="fragments/header.jsp" %>
<div class="container">
    <%
        Movie movie = (Movie) request.getAttribute("movie");
    %>
    <div>
        <h1>
            <br><%=movie.getName()%>
        </h1>
    </div>
    <table>
        <tbody>
        <tr>
            <td>Country:</td>
            <td><%=movie.getCountry()%>
            </td>
        </tr>
        <tr>
            <td>Premier date:</td>
            <td><%=movie.getPremierDate()
                    .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))%>
            </td>
        </tr>
        <tr>
            <td>Length:</td>
            <td><%=String.valueOf(movie.getLengthInMinutes()).concat(" minutes")%>
            </td>
        </tr>

        <tr>
            <td>Genre:</td>
            <td><%=getGenreList(movie)%>
            </td>
        </tr>
        <tr>
            <td>Tags:</td>
            <td><%=getTagList(movie)%>
            </td>
        </tr>
        </tbody>
    </table>
    <%if (movie.getDirectors().size() > 0) { %>
    <div>
        <h2>
            <br>Directors
        </h2>
    </div>
    <table>
        <thead>
        <tr>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <% for (Profile profile : movie.getDirectors()) {%>
        <tr>
            <td><%=profile.getName().concat(" ").concat(profile.getSurname())%>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <%}%>

    <%if (movie.getProducers().size() > 0) { %>
    <div>
        <h2>
            <br>Producers
        </h2>
    </div>
    <table>
        <thead>
        <tr>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <% for (Profile profile : movie.getProducers()) {%>
        <tr>
            <td><%=profile.getName().concat(" ").concat(profile.getSurname())%>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <%}%>

    <%if (movie.getActors().size() > 0) { %>
    <div>
        <h2>
            <br>Actors
        </h2>
    </div>
    <table>
        <thead>
        <tr>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <% for (Profile profile : movie.getActors()) {%>
        <tr>
            <td><%=profile.getName().concat(" ").concat(profile.getSurname())%>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <%}%>

    <%!
        public String getGenreList(Movie movie) {
            StringBuilder genres = new StringBuilder();
            Iterator<Genre> iterator = movie.getGenres().iterator();
            while (iterator.hasNext()) {
                genres.append(iterator.next().toString());
                if (iterator.hasNext()) {
                    genres.append(", ");
                }
            }
            return genres.toString().equals("") ? "none" : genres.toString();
        }

        public String getTagList(Movie movie) {
            StringBuilder tags = new StringBuilder();
            Iterator<Tag> iterator = movie.getTags().iterator();
            while (iterator.hasNext()) {
                tags.append(iterator.next().toString());
                if (iterator.hasNext()) {
                    tags.append(", ");
                }
            }
            return tags.toString().equals("") ? "none" : tags.toString();
        }
    %>

</div>
</body>
</html>
