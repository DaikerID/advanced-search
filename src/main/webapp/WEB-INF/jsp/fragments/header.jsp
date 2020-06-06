<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%--<h1>what to see</h1>--%>
<%--<h3>Load time - <%=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yy HH:mm"))%>--%>
<%--</h3>--%>

<nav class="grey">
    <div class="nav-wrapper">
        <a href="/" class="brand-logo">what to see</a>
        <ul class="right hide-on-med-and-down">
            <li>Load time - <%=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yy HH:mm"))%></li>
            <li>
                <form action="/search">
                    <div class="input-field">
                        <input id="search" name="searchLine" placeholder="Search" type="search"
                               required>
                        <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                        <i class="material-icons">close</i>
                    </div>
                </form>
            </li>
        </ul>
    </div>
</nav>

