<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container-fluid">
  <div class="col-sm-6 col-lg-4 ">
    <div class="row">
      <div class="col-sm-6">
        <c:forEach items="${param.items}" var="item">
          <fmt:formatDate value="${item.dateFinEnchere}" pattern="dd-MM-YY" var="date" type="date"/>
          <jsp:include page="/WEB-INF/homePage/fragments/_object-card.jsp">
            <jsp:param name="nom" value="${item.nom}"/>
            <jsp:param name="prix" value="${item.prix}"/>
            <jsp:param name="finEnchere" value="${date}"/>
            <jsp:param name="vendeur" value="${item.utilisateur.pseudo}"/>
          </jsp:include>
        </c:forEach>
      </div>
    </div>
  </div>
</div>