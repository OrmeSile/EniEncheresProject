<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-4 border border-primary bg-light ">
  <div class="row">
    <div class="col-4">
      <img src="${pageContext.request.contextPath}/resources/img/article_placeholder.jpg" alt="placeholder"/>
  </div>
    <div class="col-md">
      <div class="row">
        Nom : ${param.nom}
      </div>
      <div class="row">
        Prix : ${param.prix}
      </div>
      <div class="row">
        Fin le : ${param.finEnchere}
      </div>
      <div class="row">
        Vendeur : ${param.vendeur}
      </div>
    </div>
  </div>
</div>
