<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<html>
<body>
    <div id="header">
        <jsp:invoke fragment="header"/>
    </div>
    <div id="body">
        <jsp:invoke fragment="body"/>
    </div>
    <div id="footer">
        <jsp:invoke fragment="footer"/>
    </div>
</body>
</html>