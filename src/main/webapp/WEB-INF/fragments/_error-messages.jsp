<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${!empty requestScope.errors}">
  <div class="error-container">
    <ul>
      <c:forEach items="${requestScope.errors}" var="error">
        <li>${error}</li>
      </c:forEach>
    </ul>
  </div>
</c:if>