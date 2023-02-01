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
</div>
</body>
</html>
