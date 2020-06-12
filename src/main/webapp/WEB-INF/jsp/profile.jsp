<%@ page import="com.films.search.advansed.diploma.database.model.common.Profile" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.films.search.advansed.diploma.database.model.common.Movie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="fragments/head.jsp" %>
<body>
<%@ include file="fragments/header.jsp" %>
<div class="container">
    <%
        Profile profile = (Profile) request.getAttribute("profile");
    %>
    <div>
        <h1 class="white-text">
            <br><%=profile.getName().concat(" ").concat(profile.getSurname())%>
        </h1>
    </div>
    <table>
        <tbody>
        <tr>
            <td class="white-text">Career:</td>
            <td class="white-text"><%=getCareerList(profile)%>
            </td>
        </tr>
        <tr>
            <td class="white-text">Birth date:</td>
            <td class="white-text"><%=profile.getBirthDate()
                    .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))%>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="row s12">

        <%if (profile.getActor().size() > 0) { %>
        <div class="col s4">
            <div class="green darken-4">
                <ul class="collection green darken-4">
                    <li class="collection-header green darken-4"><h5 class="white-text">As
                        actor</h5></li>
                    <% for (Movie movie : profile.getActor()) {%>
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
        </div>
        <%}%>

        <%if (profile.getDirector().size() > 0) { %>
        <div class="col s4">
            <div class="green darken-4">
                <ul class="collection green darken-4">
                    <li class="collection-header green darken-4"><h5 class="white-text">As
                        director</h5>
                    </li>
                    <% for (Movie movie : profile.getDirector()) {%>
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
        </div>
        <%}%>

        <%if (profile.getProducer().size() > 0) { %>
        <div class="col s4">
        <div class="green darken-4">
            <ul class="collection green darken-4">
                <li class="collection-header green darken-4"><h5 class="white-text">As producer</h5>
                </li>
                <% for (Movie movie : profile.getProducer()) {%>
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
            </div>
        <%}%>
    </div>
    <%!
        public String getCareerList(Profile profile) {
            List<String> careers = new ArrayList<>();
            if (profile.getActor().size() > 0) {
                careers.add("Actor");
            }
            if (profile.getDirector().size() > 0) {
                careers.add("Director");
            }
            if (profile.getProducer().size() > 0) {
                careers.add("Producer");
            }
            StringBuilder careerString = new StringBuilder();
            for (String career : careers) {
                careerString.append(career);
                if (careers.indexOf(career) != careers.size() - 1) {
                    careerString.append(", ");
                }
            }
            return careerString.toString().equals("") ? "none" : careerString.toString();
        }
    %>
</div>
</body>
</html>