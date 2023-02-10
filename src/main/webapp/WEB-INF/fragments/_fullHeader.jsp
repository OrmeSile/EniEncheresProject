<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="navbar">
  <div class="brand-container">
    <jsp:include page="/WEB-INF/fragments/_header.jsp"/>
  </div>
  <div class="navbar-clickable-list-container">
    <ul class="navbar-clickable-list">
      <c:choose>
        <c:when test="${empty sessionScope.user}">
          <a class="navbar-clickable active" href=<c:url value="/login"/>>
            <li>S'inscrire/Se connecter</li>
          </a>
        </c:when>
        <c:otherwise>
          <a class="navbar-clickable" href="<c:url value="/AjoutArticle"/>">
            <li>Nouvelle vente...</li>
          </a>
          <a class="navbar-clickable" href=<c:url value="/profil"/>>
            <li>Mon Profil</li>
          </a>
          <a class="navbar-clickable" href=<c:url value="/logout"/>>
            <li>Déconnexion</li>
          </a>
        </c:otherwise>
      </c:choose>
    </ul>
  </div>
</header>