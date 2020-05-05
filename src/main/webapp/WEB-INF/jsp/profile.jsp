<%@ page import="com.films.search.advansed.diploma.database.model.Profile" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="fragments/head.jsp" %>
<body>
<%@ include file="fragments/header.jsp" %>
<div class="container">
    <%
        Profile profile = (Profile) request.getAttribute("profile");
    %>
    <div><h1><br><%=profile.getName().concat(" ").concat(profile.getSurname())%>
    </h1></div>
    <table>
        <tbody>
        <tr>
            <td>Career:</td>
            <td><%=getCareerList(profile)%>
            </td>
        </tr>
        <tr>
            <td>Birth date:</td>
            <td><%=profile.getBirthDate()
                    .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))%>
            </td>
        </tr>
        </tbody>
    </table>
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
                if(careers.indexOf(career) != careers.size()-1){
                  careerString.append(", ");
                }
            }
            return careerString.toString();
        }
    %>
</div>
</body>
</html>
