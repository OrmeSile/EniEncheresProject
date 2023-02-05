<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="article-card">
  <img class="card-img" src="${pageContext.request.contextPath}/img/article_placeholder.jpg" alt="placeholder">
  <div class="card-body">
    <ul>
      <li>
        ${param.nom}
      </li>
      <li>
        ${param.prix}
      </li>
      <li>
        ${param.finEnchere}
      </li>
      <li>
        <a href=<c:url value="/profil?userid=${param.vendeur.noUtilisateur}"/>>${param.vendeur.nom}</a>
      </li>
    </ul>
  </div>
</div>