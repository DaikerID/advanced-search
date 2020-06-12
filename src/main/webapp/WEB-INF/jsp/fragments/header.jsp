<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<nav class="green darken-4">
    <div class="nav-wrapper">
        <a href="/" class="brand-logo">what to see</a>
        <ul class="right hide-on-med-and-down">
            <li>Load time - <%=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yy HH:mm"))%></li>
            <li>
                <form action="/search">
                    <div class="input-field">
                        <input id="search" name="searchLine" placeholder="<%=localeMap.get(WebMessageCode.SEARCH)%>" type="search"
                               required>
                        <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                        <i class="material-icons">close</i>
                    </div>
                </form>
            </li>
        </ul>
    </div>
</nav>

