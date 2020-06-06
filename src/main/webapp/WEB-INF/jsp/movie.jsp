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
    <div class="green darken-4">
        <ul class="collection green darken-4">
            <li class="collection-header green darken-4"><h4 class="white-text">Directors</h4></li>
            <% for (Profile profile : movie.getDirectors()) {%>
            <a class="collection-item avatar" href="/profile//?profileId=<%=profile.getId()%>">
                <i class="material-icons circle">person</i>
                <span class="title"><%=profile.getName().concat(" ")
                        .concat(profile.getSurname())%></span>
                <p><%=profile.getBirthDate().getYear()%>
                </p>
            </a>
            <%}%>
        </ul>
    </div>
    <%}%>

    <%if (movie.getProducers().size() > 0) { %>
    <div class="green darken-4">
        <ul class="collection green darken-4">
            <li class="collection-header green darken-4"><h4 class="white-text">Producers</h4></li>
            <% for (Profile profile : movie.getProducers()) {%>
            <a class="collection-item avatar" href="/profile//?profileId=<%=profile.getId()%>">
                <i class="material-icons circle">person</i>
                <span class="title"><%=profile.getName().concat(" ")
                        .concat(profile.getSurname())%></span>
                <p><%=profile.getBirthDate().getYear()%>
                </p>
            </a>
            <%}%>
        </ul>
    </div>
    <%}%>

    <%if (movie.getActors().size() > 0) { %>
    <div class="green darken-4">
        <ul class="collection green darken-4">
            <li class="collection-header green darken-4"><h4 class="white-text">Actors</h4></li>
            <% for (Profile profile : movie.getActors()) {%>
            <a class="collection-item avatar" href="/profile//?profileId=<%=profile.getId()%>">
                <i class="material-icons circle">person</i>
                <span class="title"><%=profile.getName().concat(" ")
                        .concat(profile.getSurname())%></span>
                <p><%=profile.getBirthDate().getYear()%>
                </p>
            </a>
            <%}%>
        </ul>
    </div>
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
