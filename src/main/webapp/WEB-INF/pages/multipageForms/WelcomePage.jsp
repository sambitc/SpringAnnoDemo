<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <body>
        <h2>Handling multipage forms in Spring MVC</h2>
        Click here to start playing -
        <a href='<spring:url value="/user" htmlEscape="true"/>'>AbstractWizardFormController example</a>
    </body>
</html>