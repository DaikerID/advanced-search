<%@ page import="com.films.search.advansed.diploma.database.model.values.Genre" %>
<%@ page import="com.films.search.advansed.diploma.database.model.common.Movie" %>
<%@ page import="com.films.search.advansed.diploma.database.model.common.Profile" %>
<%@ page import="com.films.search.advansed.diploma.database.model.values.Tag" %>
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
        <h1 class="white-text">
            <br><%=movie.getName()%>
        </h1>
    </div>
    <table>
        <tbody>
        <tr>
            <td class="white-text">Country:</td>
            <td class="white-text"><%=movie.getCountry()%>
            </td>
        </tr>
        <tr>
            <td class="white-text">Premier date:</td>
            <td class="white-text"><%=movie.getPremierDate()
                    .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))%>
            </td>
        </tr>
        <tr>
            <td class="white-text">Length:</td>
            <td class="white-text"><%=String.valueOf(movie.getLengthInMinutes())
                    .concat(" minutes")%>
            </td>
        </tr>

        <tr>
            <td class="white-text">Genre:</td>
            <td class="white-text"><%=getGenreList(movie)%>
            </td>
        </tr>
        <tr>
            <td class="white-text">Tags:</td>
            <td class="white-text"><%=getTagList(movie)%>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="row s12">
        <%if (movie.getActors().size() > 0) { %>
        <div class="col s4">
            <div class="green darken-4">
                <ul class="collection green darken-4">
                    <li class="collection-header green darken-4"><h4 class="white-text">Actors</h4>
                    </li>
                    <% for (Profile profile : movie.getActors()) {%>
                    <a class="collection-item avatar"
                       href="/profile//?profileId=<%=profile.getId()%>">
                        <i class="material-icons circle">person</i>
                        <span class="title"><%=profile.getName().concat(" ")
                                .concat(profile.getSurname())%></span>
                        <p><%=profile.getBirthDate().getYear()%>
                        </p>
                    </a>
                    <%}%>
                </ul>
            </div>
        </div>
        <%}%>

        <%if (movie.getDirectors().size() > 0) { %>
        <div class="col s4">
            <div class="green darken-4">
                <ul class="collection green darken-4">
                    <li class="collection-header green darken-4"><h4 class="white-text">
                        Directors</h4></li>
                    <% for (Profile profile : movie.getDirectors()) {%>
                    <a class="collection-item avatar"
                       href="/profile//?profileId=<%=profile.getId()%>">
                        <i class="material-icons circle">person</i>
                        <span class="title"><%=profile.getName().concat(" ")
                                .concat(profile.getSurname())%></span>
                        <p><%=profile.getBirthDate().getYear()%>
                        </p>
                    </a>
                    <%}%>
                </ul>
            </div>
        </div>
        <%}%>

        <%if (movie.getProducers().size() > 0) { %>
        <div class="col s4">
            <div class="green darken-4">
                <ul class="collection green darken-4">
                    <li class="collection-header green darken-4"><h4 class="white-text">
                        Producers</h4>
                    </li>
                    <% for (Profile profile : movie.getProducers()) {%>
                    <a class="collection-item avatar"
                       href="/profile//?profileId=<%=profile.getId()%>">
                        <i class="material-icons circle">person</i>
                        <span class="title"><%=profile.getName().concat(" ")
                                .concat(profile.getSurname())%></span>
                        <p><%=profile.getBirthDate().getYear()%>
                        </p>
                    </a>
                    <%}%>
                </ul>
            </div>
        </div>
        <%}%>
    </div>

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
