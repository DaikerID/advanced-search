<%@ page import="com.films.search.advansed.diploma.LocalDateTimeUtils" %>
<%@ page import="com.films.search.advansed.diploma.database.model.values.Genre" %>
<%@ page import="com.films.search.advansed.diploma.database.model.common.Movie" %>
<%@ page import="com.films.search.advansed.diploma.database.model.common.Profile" %>
<%@ page import="com.films.search.advansed.diploma.database.model.values.Tag" %>
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

<div class="container">
    <form action="/advanced-search">
        <h2 class="white-text">Advanced movie search</h2>
        <div class="input-field">
            <input type="text" id="movieName" name="movieName">
            <label for="movieName">By movie name</label>
            <span class="helper-text white-text" data-error="wrong" data-success="right">Full name or part of it</span>
        </div>
        <div class="row">
            <div class="col s6">
                <div class="actorsContainer">
                    <div class="actorInput">
                        <div class="input-field">
                            <input type="text" id="actors" name="actors" class="validate">
                            <label for="actors">By actor</label>
                            <span class="helper-text white-text" data-error="wrong"
                                  data-success="right">Full name or part of it</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col s6">
                <a class="waves-effect green darken-4 btn" id="addActorButton">Add actor</a>
            </div>
        </div>
        <div class="row">
            <div class="col s6">
                <div class="directorsContainer">
                    <div class="directorInput">
                        <div class="input-field">
                            <input type="text" id="directors" name="directors">
                            <label for="directors">By director</label>
                            <span class="helper-text white-text" data-error="wrong"
                                  data-success="right">Full name or part of it</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col s6">
                <a class="waves-effect green darken-4 btn" id="addDirectorButton">Add
                    director</a>
            </div>
        </div>
        <div class="row">
            <div class="col s6">
                <div class="producerContainer">
                    <div class="producerInput">
                        <div class="input-field">
                            <input type="text" id="producers" name="producers">
                            <label for="producers">By producer</label>
                            <span class="helper-text white-text" data-error="wrong"
                                  data-success="right">Full name or part of it</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col s6">
                <a class="waves-effect green darken-4 btn" id="addProducerButton">Add
                    producer</a>
            </div>
        </div>

        <div class="input-field">
            <input type="text" id="country" name="countries">
            <label for="country">By country</label>
        </div>

        <div class="row">
            <div class="col s3">
                <div class="tagSelectorContainer">
                    <label>Choose a tags:</label>
                    <div class="tagSelector">
                        <select name="tags" multiple>
                            <option class="white" value="-" disabled selected>By tag</option>
                            <%
                                Map<Tag, String> tagsMap = (HashMap<Tag, String>) request
                                        .getAttribute("tagsMap");
                                for (Tag tag : Tag.values()) {%>
                            <option class="white" value="<%=tag.toString()%>"><%=tagsMap
                                    .get(tag)%></option>
                            <%}%>
                        </select>
                    </div>
                </div>
            </div>

            <div class="col s3">
                <div class="genreSelectorContainer">
                    <label>Choose a genre:</label>
                    <div class="genreSelector">
                        <select name="genres" multiple>
                            <option class="white" value="-" disabled selected>By genre</option>
                            <%
                                Map<Genre, String> genresMap = (HashMap<Genre, String>) request
                                        .getAttribute("genresMap");
                                for (Genre genre : Genre.values()) {%>
                            <option class="white" value="<%=genre.toString().trim()%>"><%=genresMap
                                    .get(genre)%></option>
                            <%}%>
                        </select>

                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <p><label>Choose a begining of release date interval:</label>
            <div class="col s1">
                <select name="releaseDayStart">
                    <option value="-">day</option>
                    <% for (int i = 1; i <= 31; i++) {%>
                    <option value="<%=i%>"><%=i%>
                    </option>
                    <%}%>
                </select>
            </div>
            <div class="col s3">
                <select name="releaseMonthStart">
                    <option value="-">after month</option>
                    <%
                        Map<Month, String> monthsMap = (HashMap<Month, String>) request
                                .getAttribute("monthsMap");
                        for (Month month : Month.values()) {%>
                    <option value="<%=month.toString()%>"><%=monthsMap.get(month)%>
                    </option>
                    <%}%>
                </select>
            </div>
            <div class="col s2">
                <select name="releaseYearStart">
                    <option value="-">after year</option>
                    <% int firstFilmYear = LocalDateTimeUtils.FIRST_FILM_DATE.getYear();
                        for (int i = LocalDate.now().getYear(); i >= firstFilmYear; i--) {%>
                    <option value="<%=i%>"><%=i%>
                    </option>
                    <%}%>
                </select>
            </div>
        </div>
        <div class="row">
            <p><label>Choose a ending of release date interval:</label>
            <div class="col s1">
                <select name="releaseDayEnd">
                    <option value="-">day</option>
                    <% for (int i = 1; i <= 31; i++) {%>
                    <option value="<%=i%>"><%=i%>
                    </option>
                    <%}%>
                </select>
            </div>
            <div class="col s3">
                <select name="releaseMonthEnd">
                    <option value="-">before month</option>
                    <% for (Month month : Month.values()) {%>
                    <option value="<%=month.toString()%>"><%=monthsMap.get(month)%>
                    </option>
                    <%}%>
                </select>
            </div>
            <div class="col s2">
                <select name="releaseYearEnd">
                    <option value="-">before year</option>
                    <% for (int i = LocalDate.now().getYear(); i >= firstFilmYear; i--) {%>
                    <option value="<%=i%>"><%=i%>
                    </option>
                    <%}%>
                </select>
            </div>
        </div>
        <button class="btn waves-effect green darken-4" type="submit" name="action">search movie
            by
            criteria
            <i class="material-icons right">search</i>
        </button>
    </form>

    <div>
        <% List<Movie> movies = (List<Movie>) request.getAttribute("movies");
            if (movies.size() > 0) {%>
        <div class="green darken-4">
            <ul class="collection green darken-4">
                <li class="collection-header green darken-4"><h4 class="white-text">Movies</h4>
                </li>
                <% for (Movie movie : movies) {%>
                <a class="collection-item avatar" href="/movie/?movieId=<%=movie.getId()%>">
                    <i class="material-icons circle">movie</i>
                    <span class="title"><%=movie.getName()%></span>
                    <p><%=movie.getPremierDate().getYear()%> <br>
                        <%=movie.getCountry()%>
                    </p>
                </a>
                <%}%>
            </ul>
        </div>
        <%}%>
    </div>
    <div>
        <%
            List<Profile> profiles = (List<Profile>) request.getAttribute("profiles");
            if (profiles.size() > 0) {%>
        <div class="green darken-4">
            <ul class="collection green darken-4">
                <li class="collection-header green darken-4"><h4 class="white-text">
                    Profiles</h4>
                </li>
                <% for (Profile profile : profiles) {%>
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
        <%
            }

            if (profiles.size() == 0 && movies.size() == 0) {%>
        <h1>${NO_RESULTS}</h1>
        <%
            }
        %>
    </div>
</div>
<script>
  $(function () {
    $(document).ready(function () {
      $('select').material_select();
    });

    //============-------------ADDING_FIELDS-----------------------------------------
    $('#addActorButton').click(function () {
      $(".actorInput").first().clone(true).appendTo(".actorsContainer");
      return false;
    });

    $('#addDirectorButton').click(function () {
      $(".directorInput").first().clone(true).appendTo(".directorsContainer");
      return false;
    });

    $('#addProducerButton').click(function () {
      $(".producerInput").first().clone(true).appendTo(".producerContainer");
      return false;
    });
  })
</script>
</body>
</html>