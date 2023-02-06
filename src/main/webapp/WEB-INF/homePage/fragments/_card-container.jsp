<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container-fluid">
  <div class="row">
    <c:forEach items="${param.items}" var="item">
      <div class="col-lg-6 col-xl-4">
        <jsp:include page="/WEB-INF/homePage/fragments/_object-card.jsp">
          <jsp:param name="nom" value="${item.nom}"/>
          <jsp:param name="prix" value="${item.prix}"/>
          <jsp:param name="finEnchere" value="${item.dateFinEncheres.toLocalDate()}"/>
          <jsp:param name="id" value="${item.vendeur.noUtilisateur}"/>
          <jsp:param name="vnom" value="${item.vendeur.nom}"/>
        </jsp:include>
      </div>
    </c:forEach>
  </div>
</div>
