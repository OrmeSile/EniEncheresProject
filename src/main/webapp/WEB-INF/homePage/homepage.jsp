<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Page d'accueil</title>
  <jsp:include page="/WEB-INF/fragments/_normalize-import.jsp"/>
  <link rel="stylesheet" href="<c:url value="/css/shared/header.css"/>">
  <link rel="stylesheet" href="<c:url value="/css/homepage/homepage.css"/>">
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
            <c:when test="${empty sessionScope.user}">
              <a class="navbar-clickable active" href=<c:url value="/login"/>>
                <li>S'inscrire/Se connecter</li>
              </a>
            </c:when>
            <c:otherwise>
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
    <div class="container-main">
      <div class="container-form-filter">
        <form id="filter" name="filter-form" method="post" action=<c:url value="/home"/>>
          <div>
            <div class="form-text-cat-input">
              <input type="text" name="searchfield" placeholder="chercher article">
              <div>
                <label for="select-dropdown-categories">Catégorie :</label>
                <select id="select-dropdown-categories" name="selectedCategory" form="filter">
                  <option>Tous</option>
                  <c:forEach var="categorie" items="${requestScope.categories}">
                    <option>
                        ${categorie.libelle}
                    </option>
                  </c:forEach>
                </select>
              </div>
            </div>
            <div>
              <c:if test="${not empty sessionScope.user}">
                <div class="toggle-filters">
                  <div class="radio-group">
                    <input type="radio" name="filter" value="buy" id="buy">
                    <label for="buy">Achats</label>
                    <input type="radio" name="filter" value="sell" id="sell">
                    <label for="sell">Mes ventes</label>
                  </div>
                  <div class="checkbox-group-container">
                    <div class="checkbox-group">
                      <div>
                        <input type="checkbox" value="open" id="bopen">
                        <label for="bopen">enchères ouvertes</label>
                      </div>
                      <div>
                        <input type="checkbox" value="self" id="bself">
                        <label for="bself">mes enchères</label>
                      </div>
                      <div>
                        <input type="checkbox" value="won" id="bwon">
                        <label for="bwon">mes enchères remportées</label>
                      </div>
                    </div>
                    <div class="checkbox-group">
                      <div>
                        <input type="checkbox" value="open" id="sopen">
                        <label for="sopen">mes ventes en cours</label>
                      </div>
                      <div>
                        <input type="checkbox" value="self" id="sself">
                        <label for="sself">ventes non débutées</label>
                      </div>
                      <div>
                        <input type="checkbox" value="won" id="swon">
                        <label for="swon">ventes terminées</label>
                      </div>
                    </div>
                  </div>
                </div>
              </c:if>
            </div>
          </div>
          <div class="submit">
            <input type="submit" value="Rechercher">
          </div>
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
