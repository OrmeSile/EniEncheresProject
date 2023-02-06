<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="alert-error">
  <ul>
    <c:forEach items="${param.errors}" var="error">
      <li>${error}</li>
    </c:forEach>
  </ul>
</div>