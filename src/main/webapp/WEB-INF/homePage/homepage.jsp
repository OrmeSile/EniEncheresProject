<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Page d'accueil</title>
<%--  <jsp:include page="/WEB-INF/fragments/_bootstrap-import.jsp"/>--%>
  <link rel="stylesheet" href="<c:url value="/css/fragments/_article-card/_article-card.css"/>">
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
            <c:when test="${empty sessionScope.utilisateur}">
              <li class="nav-item active">
                <a class="col" href=<c:url value="/login"/>>S'inscrire/Se connecter</a>
              </li>
            </c:when>
            <c:otherwise>
				<li class="nav-item"><a class="col" href=<c:url value="/monProfil"/>>Mon profil</a></li>
              <li class="nav-item">
                <a class="col" href=<c:url value="/logout"/>>Déconnexion</a>
              </li>

            </c:otherwise>
          </c:choose>
        </ul>
      </div>
      <div>

      </div>
    </header>
    <div class="row">
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
      <c:forEach items="${requestScope.articles}" var="item">
        <div class="col-lg-6 col-xl-4">
        <jsp:include page="/WEB-INF/homePage/fragments/_object-card.jsp">
          <jsp:param name="nom" value="${item.nomArticle}"/>
          <jsp:param name="prix" value="${item.prixVente}"/>
          <jsp:param name="finEnchere" value="${item.dateFinEncheres.toLocalDate()}"/>
          <jsp:param name="id" value="${item.vendeur.noUtilisateur}"/>
          <jsp:param name="vnom" value="${item.vendeur.nom}"/>
        </jsp:include>
        </div>
      </c:forEach>
      </div>
    </div>
  </body>
</html>
