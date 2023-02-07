<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card-container">
  <div class="article-card">
    <img class="card-img" src="<c:url value="/img/article_placeholder.jpg"/>" alt="placeholder">
    <div class="card-body">
      <ul>
        <li>
          <span class="article-title">${param.nom}</span>
        </li>
        <li>
          <span class="article-price">${param.prix} €</span>
        </li>
        <li>
          <span class="article-bidding-end-date"> ${param.finEnchere}</span>
        </li>
        <li>
         <a href=<c:url value="/profil?userid=${param.id}"/>> <span class="article-seller">${param.vnom}</span></a>
        </li>
      </ul>
    </div>
  </div>
</div>