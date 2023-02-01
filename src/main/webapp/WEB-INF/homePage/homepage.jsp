<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Page d'accueil</title>
  <jsp:include page="/WEB-INF/fragments/_bootstrap-import.jsp"/>
</head>
<body>
<div class="container">
  <header class="row navbar navbar-expand-md bg-dark-subtle d-flex align-content-between">
    <div class="col-2">
      <jsp:include page="/WEB-INF/fragments/_header.jsp"/>
    </div>
    <div class="col-3">
      <a class="col-2" href="${pageContext.request.contextPath}/login">S'inscrire/Se connecter</a>
    </div>
  </header>
  <div class="row">
  <div class="col-6">
<%--TODO js filter for names ?--%>
    <label>Catégorie :
      <select name="selectedCategory">
        <c:forEach var="categorie" items="${requestScope.categories}">
          <option>
            ${categorie.libelle}
          </option>
        </c:forEach>
      </select>
    </label>
    <c:forEach var="article" items="${requestScope.items}">
      <jsp:include page="/WEB-INF/fragments/_object-Card.jsp">
        <jsp:param name="nom" value="${article.nomArticle}"/>
        <jsp:param name="prix" value="${article.prixVente}"/>
        <jsp:param name="finEnchere" value="${article.dateFinEnchere}"/>
        <jsp:param name="pseudo" value="${article.utilisateur.pseudo}"/>
      </jsp:include>
    </c:forEach>
  </div>
  <div class="col-6">
    <div class="row">
      <form method="post" action="${requestScope.request.contextPath}/home">
        <input type="submit" value="Rechercher">
      </form>
    </div>
  </div>
  </div>
</div>
</body>
</html>
