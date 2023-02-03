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
      <a <li class="list-group-item">
        ${param.vendeur}
      </li>
    </ul>
  </div>
</div>