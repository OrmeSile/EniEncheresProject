<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Page d'accueil</title>
  <jsp:include page="/WEB-INF/fragments/_bootstrap-import.jsp"/>
</head>
<body>
  <div class="container-fluid">
    <header class="row navbar navbar-expand-md bg-dark-subtle d-flex align-content-between">
      <div class="col-2">
        <jsp:include page="/WEB-INF/fragments/_header.jsp"/>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
          <c:choose>
            <c:when test="${sessionScope.utilisateur eq null}">
              <li class="nav-item active">
                <a class="col" href=<c:url value="/login"/>>S'inscrire/Se connecter</a>
              </li>
            </c:when>
            <c:otherwise>
              <li class="nav-item">
                <a class="col" href=<c:url value="/logout"/>>Déconnexion</a>
              </li>
            </c:otherwise>
          </c:choose>
        </ul>
      </div>
    </header>
    <div class="row">
  <%--TODO js filter for names ?--%>
      <label>Catégorie :
        <select name="selectedCategory">
          <option>Tous</option>
          <c:forEach var="categorie" items="${requestScope.categories}">
            <option>
              ${categorie.libelle}
            </option>
          </c:forEach>
        </select>
      </label>
      <form method="post" action="${requestScope.request.contextPath}/home">
        <input type="submit" value="Rechercher">
      </form>
    </div>
    <div class=row>
      <c:forEach var="article" items="${requestScope.items}">
        <jsp:include page="/WEB-INF/fragments/_object-Card.jsp">
          <jsp:param name="nom" value="${article.nomArticle}"/>
          <jsp:param name="prix" value="${article.prixVente}"/>
          <jsp:param name="finEnchere" value="${article.dateFinEnchere}"/>
          <jsp:param name="pseudo" value="${article.utilisateur.pseudo}"/>
        </jsp:include>
      </c:forEach>
    </div>
  </div>
</body>
</html>
