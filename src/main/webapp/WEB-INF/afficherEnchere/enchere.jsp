<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="article" scope="request" type="fr.eni.ecole.encheres.bo.ArticleVendu"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="https://tools.encheres.ecole.eni.fr/functions"%>
<!DOCTYPE html>
<html>
<head>
    <title>Eni Enchères - ${requestScope.article.nomArticle}</title>
  <link rel="stylesheet" href=<c:url value="/css/afficherEnchere/afficherEnchere.css"/>>
  <link rel="stylesheet" href="<c:url value="/css/fragments/_errors/errors.css"/>">
  <link rel="stylesheet" href="<c:url value="/css/shared/header.css"/>">
  <jsp:include page="/WEB-INF/fragments/_normalize-import.jsp"/>
</head>
<body>
  <div class="container">
  <jsp:include page="/WEB-INF/fragments/_fullHeader.jsp"/>
    <jsp:include page="/WEB-INF/fragments/_error-messages.jsp"/>
    <div class="main-container">
      <div class="title-container">
        <h2>Détail vente</h2>
      </div>
      <div class="info-container">
        <div class="image-container">
          <div class="image">
            <img src="<c:url value="/img/article_placeholder.jpg"/>" alt="image de l'article"/>
          </div>
        </div>
        <div class="main-fields">
          <div>
            <h4>${article.nomArticle}</h4>
          </div>
          <div>
            <label for="description" >Description :</label>
            <p id="description">${article.description}</p>
          </div>
          <div>
            <label for="categorie">Catégorie</label>
            <p id="categorie">${article.categorieArticle.libelle}</p>
          </div>
          <div>
            <label for="offre">Meilleure offre :</label>
            <p id="offre">${!empty article.enchere ? article.enchere.montantEnchere += ' pts par ' += article.enchere.encherisseur.nom : 'pas d\'offre pour le moment.'}</p>
          </div>
          <div>
            <label for="prix">Mise à prix :</label>
            <p id="prix">${article.prixVente} points</p>
          </div>
          <div>
            <label for="fin">Fin de l'enchère</label>
            <p id="fin">${f:formatLocalDateTime(article.dateFinEncheres, "dd.MM.yyyy à HH:mm")}</p>
          </div>
          <div>
            <label for="vendeur">Vendeur :</label>
            <c:choose>
              <c:when test="${!empty sessionScope.user}">
                <a id="vendeur" href="<c:url value="/profil?userid=${article.vendeur.noUtilisateur}"/>">${article.vendeur.pseudo}</a>
              </c:when>
              <c:otherwise>
                <p id="vendeur">${article.vendeur.pseudo}</p>
              </c:otherwise>
            </c:choose>
          </div>
          <jsp:useBean id="date" scope="request" type="java.time.LocalDateTime"/>
          <c:if test="${!empty sessionScope.user && article.dateDebutEncheres.isAfter(date)}">
            <c:choose>
              <c:when test="${sessionScope.user.noUtilisateur != article.vendeur.noUtilisateur && article.enchere.encherisseur.noUtilisateur != sessionScope.user.noUtilisateur}">
                <form method="post" action="<c:url value="/afficherEnchere"/> ">
                  <label for="proposition">Ma proposition :</label>
                  <input type="hidden" name="itemId" value="${article.noArticle}">
                  <input type="number" id="proposition" name="proposition" value="${!empty article.enchere ? article.enchere.montantEnchere + 1 : article.miseAPrix +1}">
                  <input type="submit" value="Enchérir">
                </form>
              </c:when>
              <c:when test="${sessionScope.user.noUtilisateur == article.vendeur.noUtilisateur}">
                <a href="<c:url value="/"/>"></a><input type="button" value="Modifier">
              </c:when>
            </c:choose>
          </c:if>
        </div>
      </div>
    </div>
    </div>
</body>
</html>
