<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card text-center">
  <img class="card-img" src="${pageContext.request.contextPath}/img/article_placeholder.jpg" alt="placeholder">
  <div class="card-body">
    <ul class="list-group list-group-flush">
      <li class="list-group-item">
        ${param.nom}
      </li>
      <li class="list-group-item">
        ${param.prix}
      </li>
      <li class="list-group-item">
        ${param.finEnchere}
      </li>
      <li class="list-group-item">
        <a href=<c:url value="${pageContext.request.contextPath}/profil?userid=${param.vendeur.noUtilisateur}"/>>${param.vendeur.pseudo}</a>
      </li>
    </ul>
  </div>
</div>