<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card-container">
  <div class="article-card">
    <img class="card-img" src="<c:url value="/img/article_placeholder.jpg"/>" alt="placeholder">
    <div class="card-body">
      <ul class="card-fields">
        <li>
          <c:choose>
            <c:when test="${not empty sessionScope.user}">
              <a href="<c:url value="/afficherEnchere?id=${param.articleId}"/>"><span class="article-title">${param.nom}</span></a>
            </c:when>
            <c:otherwise>
              <h3 class="article-title">${param.nom}</h3>
            </c:otherwise>
          </c:choose>
        </li>
        <li>
          <p>Enchère actuelle :</p><p>${param.prix} €</p>
        </li>
        <li>
          <p class="article-bidding-end-date">Fin d'enchère le :</p><p>${param.finEnchere}</p>
        </li>
        <li>
          <c:choose>
            <c:when test="${empty sessionScope.user}">
              <p>Vendeur :</p>
              <p><span class="article-seller lastname">${param.vprenom}</span> <span class="article-seller firstname">${param.vnom}</span></p>
            </c:when>
            <c:otherwise>
              <p>Vendeur :</p>
              <a href=<c:url value="/profil?userid=${param.userId}"/>>
                <p><span class="article-seller lastname">${param.vprenom}</span> <span class="article-seller firstname">${param.vnom}</span></p>
              </a>
            </c:otherwise>
          </c:choose>
        </li>
      </ul>
    </div>
  </div>
</div>