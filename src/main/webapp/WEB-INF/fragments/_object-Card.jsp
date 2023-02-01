<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container" style="border: dashed black 2px">
  <div class="row">
    <div class="col-md-4">
      <img src="${pageContext.request.contextPath}/resources/img/article_placeholder.jpg" alt="placeholder"/>
  </div>
    <div class="col-md">
      <div class="row">
        ${param.nom}
      </div>
      <div class="row">
        ${param.prix}
      </div>
      <div class="row">
        ${param.finEnchere}
      </div>
      <div class="row">
        ${param.vendeur}
      </div>
    </div>
  </div>
</div>