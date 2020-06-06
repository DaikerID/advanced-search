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
<body class="grey darken-3">
<%@ include file="fragments/header.jsp" %>

<div class="container">
    <form action="/advanced-search">
        <h2>Advanced search</h2>
        <p><input type="search" name="movieName" placeholder="By name">
        <div class="row">
            <div class="col s6">
                <div class="actorsContainer">
                    <div class="actorInput">
                        <input type="search" name="actors" placeholder="By actor">
                    </div>
                </div>
            </div>
            <div class="col s6">
                <a class="waves-effect waves-light btn" id="addActorButton">Add actor</a>
            </div>
        </div>
        <div class="row">
            <div class="col s6">
                <div class="directorsContainer">
                    <div class="directorInput">
                        <input type="search" name="directors" placeholder="By director">

                    </div>
                </div>
            </div>
            <div class="col s6">
                <a class="waves-effect waves-light btn" id="addDirectorButton">Add
                    director</a>
            </div>
        </div>
        <div class="row">
            <div class="col s6">
                <div class="producerContainer">
                    <div class="producerInput">
                        <input type="search" name="producers" placeholder="By producer">

                    </div>
                </div>
            </div>
            <div class="col s6">
                <a class="waves-effect waves-light btn" id="addProducerButton">Add
                    producer</a>
            </div>
        </div>

        <p><input type="search" name="countries" placeholder="countries">

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
                            <option class="white" value="<%=tag.toString()%>"><%=tagsMap.get(tag)%>
                            </option>
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
                            <option class="white" value="<%=genre.toString()%>"><%=genresMap
                                    .get(genre)%>
                            </option>
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
        <button class="btn waves-effect waves-light" type="submit" name="action">search film by
            criteria
            <i class="material-icons right">search</i>
        </button>
    </form>
</div>
<script>
  // document.addEventListener('DOMContentLoaded', function() {
  //   var elems = document.querySelectorAll('select');
  //   var instances = M.FormSelect.init(elems, options);
  // });

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
    //==========-----------------------------------------------------------------------
    // initialize
    $('.materialSelect').material_select();

    // setup listener for custom event to re-initialize on change
    $('.materialSelect').on('contentChanged', function () {
      $(this).material_select();
    });

    // update function for demo purposes
    $("#myButton").click(function () {

      // add new value
      var newValue = getNewDoggo();
      var $newOpt = $("<option>").attr("value", newValue).text(newValue)
      $("#myDropdown").append($newOpt);

      // fire custom event anytime you've updated select
      $("#myDropdown").trigger('contentChanged');

    });

    $(function () {
      $('#demo5-1').colorpicker();
      $('#demo5-2').colorpicker();
      $('#demo5-3').colorpicker({
        container: true,
        color: "rgba(100, 181, 246)",
        inline: true
      });
    });
  })
</script>
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

            if (profiles.size() == 0 && movies.size() == 0) {%>
        <h1>${NO_RESULTS}</h1>
        <%
            }
        %>
    </div>
</div>
</body>
</html>