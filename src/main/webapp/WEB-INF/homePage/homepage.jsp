<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Page d'accueil</title>
<%--  <jsp:include page="/WEB-INF/fragments/_bootstrap-import.jsp"/>--%>
  <link rel="stylesheet" href="<c:url value="/css/fragments/_article-card/_article-card.css"/>">
</head>
<body>
  <div class="container">
    <header class="navbar">
      <div class="brand-container">
        <jsp:include page="/WEB-INF/fragments/_header.jsp"/>
      </div>
      <div class="navbar-clickable-list-container">
        <ul class="navbar-clickable-list">
          <c:choose>
            <c:when test="${empty sessionScope.utilisateur}">
              <li class="navbar-clickable active">
                <a class="col" href=<c:url value="/login"/>>S'inscrire/Se connecter</a>
              </li>
            </c:when>
            <c:otherwise>
              <li class="navbar-clickable">
                <a class="col" href=<c:url value="/monProfil"/>>Mon profil</a>
              </li>
              <li class="navbar-clickable">
                <a class="col" href=<c:url value="/logout"/>>Déconnexion</a>
              </li>
            </c:otherwise>
          </c:choose>
        </ul>
      </div>
    </header>
    <div class="container-main">
      <div class="container-form-filter">
        <label>Catégorie :
          <select name="selectedCategory" form="filter">
            <option>Tous</option>
            <c:forEach var="categorie" items="${requestScope.categories}">
              <option>
                ${categorie.libelle}
              </option>
            </c:forEach>
          </select>
        </label>
        <form id="filter" name="filter" method="post" action="${requestScope.request.contextPath}/home">
          <input type="submit" value="Rechercher">
        </form>
      </div>

      <div class="container-article-card">
        <c:forEach items="${requestScope.articles}" var="item">
          <jsp:include page="/WEB-INF/homePage/fragments/_object-card.jsp">
            <jsp:param name="nom" value="${item.nomArticle}"/>
            <jsp:param name="prix" value="${item.prixVente}"/>
            <jsp:param name="finEnchere" value="${item.dateFinEncheres.toLocalDate()}"/>
            <jsp:param name="id" value="${item.vendeur.noUtilisateur}"/>
            <jsp:param name="vnom" value="${item.vendeur.nom}"/>
          </jsp:include>
        </c:forEach>
      </div>
    </div>
  </div>
</body>
</html>
