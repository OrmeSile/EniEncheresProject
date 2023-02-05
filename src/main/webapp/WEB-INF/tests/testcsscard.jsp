<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: orme
  Date: 05/02/2023
  Time: 09:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href=<c:url value="/css/fragments/_article-card/_article-card.css"/> >
    <title>Title</title>
</head>
<body>
<div class="card-container">
  <c:forEach items="${requestScope.articles}" var="item">
  <jsp:include page="../testsjsp/_object-card.jsp">
    <jsp:param name="nom" value="${item.nomArticle}"/>
    <jsp:param name="prix" value="${item.prixVente}"/>
    <jsp:param name="finEnchere" value="${item.dateFinEncheres.toLocalDate()}"/>
    <jsp:param name="id" value="${item.vendeur.noUtilisateur}"/>
    <jsp:param name="vnom" value="${item.vendeur.nom}"/>
  </jsp:include>
  </c:forEach>
</div>
</body>
</html>
