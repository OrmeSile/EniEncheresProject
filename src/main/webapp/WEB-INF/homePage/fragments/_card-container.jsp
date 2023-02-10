<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <div class="card-container">
    <c:forEach items="${param.items}" var="item">
        <jsp:include page="/WEB-INF/homePage/fragments/_object-card.jsp">
          <jsp:param name="articleId" value="${item.noArticle}"/>
          <jsp:param name="nom" value="${item.nom}"/>
          <jsp:param name="prix" value="${item.prix}"/>
          <jsp:param name="finEnchere" value="${item.dateFinEncheres.toLocalDate()}"/>
          <jsp:param name="userId" value="${item.vendeur.noArticle}"/>
          <jsp:param name="vnom" value="${item.vendeur.nom}"/>
        </jsp:include>
    </c:forEach>
  </div>