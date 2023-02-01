<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Page d'accueil</title>
  <jsp:include page="/WEB-INF/fragments/_bootstrap-import.jsp"/>
</head>
<body>
  <div class="container-fluid text-center justify-content-center">
    <header class="row navbar navbar-expand-md bg-dark-subtle d-flex align-content-between text-end">
      <div class="col-2">
        <jsp:include page="/WEB-INF/fragments/_brand.jsp"/>
      </div>
      <div class="col-10 text-end">
        <a href="${pageContext.request.contextPath}/login">S'inscrire/Se connecter</a>
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
      <form method="post" action="${pageContext.request.contextPath}/home">
        <input type="submit" value="Rechercher">
      </form>
    </div>
    <div class="row" >
      <jsp:include page="/WEB-INF/fragments/_object-Card.jsp">
        <jsp:param name="nom" value="nom"/>
        <jsp:param name="prix" value="prix"/>
        <jsp:param name="finEnchere" value="$finEnchere"/>
        <jsp:param name="pseudo" value="$pseudo"/>
      </jsp:include>
      <jsp:include page="/WEB-INF/fragments/_object-Card.jsp">
        <jsp:param name="nom" value="nom"/>
        <jsp:param name="prix" value="prix"/>
        <jsp:param name="finEnchere" value="$finEnchere"/>
        <jsp:param name="pseudo" value="$pseudo"/>
      </jsp:include>
      <jsp:include page="/WEB-INF/fragments/_object-Card.jsp">
        <jsp:param name="nom" value="nom"/>
        <jsp:param name="prix" value="prix"/>
        <jsp:param name="finEnchere" value="$finEnchere"/>
        <jsp:param name="pseudo" value="$pseudo"/>
      </jsp:include>
      <jsp:include page="/WEB-INF/fragments/_object-Card.jsp">
        <jsp:param name="nom" value="nom"/>
        <jsp:param name="prix" value="prix"/>
        <jsp:param name="finEnchere" value="$finEnchere"/>
        <jsp:param name="pseudo" value="$pseudo"/>
      </jsp:include>
      <jsp:include page="/WEB-INF/fragments/_object-Card.jsp">
        <jsp:param name="nom" value="nom"/>
        <jsp:param name="prix" value="prix"/>
        <jsp:param name="finEnchere" value="$finEnchere"/>
        <jsp:param name="pseudo" value="$pseudo"/>
      </jsp:include>
      <jsp:include page="/WEB-INF/fragments/_object-Card.jsp">
        <jsp:param name="nom" value="nom"/>
        <jsp:param name="prix" value="prix"/>
        <jsp:param name="finEnchere" value="$finEnchere"/>
        <jsp:param name="pseudo" value="$pseudo"/>
      </jsp:include>
    </div>


      <c:forEach var="article" items="${requestScope.items}">
        <jsp:include page="/WEB-INF/fragments/_object-Card.jsp">
          <jsp:param name="nom" value="${article.nomArticle}"/>
          <jsp:param name="prix" value="${article.prixVente}"/>
          <jsp:param name="finEnchere" value="${article.dateFinEnchere}"/>
          <jsp:param name="pseudo" value="${article.utilisateur.pseudo}"/>
        </jsp:include>
      </c:forEach>
  </div>
</body>
</html>
