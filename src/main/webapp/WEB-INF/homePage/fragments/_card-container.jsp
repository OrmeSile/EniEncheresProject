<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-fluid">
  <div class="row">
    <c:forEach items="${param.items}" var="item">
      <div class="col-lg-6 col-xl-4">
        <fmt:parseDate value="${item.dateDebutEncheres.toLocalDate()}" var="date" pattern="yyyy-MM-dd" type="date"/>
        <fmt:formatDate pattern='dd/MM/yyyy' value='${date}'/>
        <jsp:include page="/WEB-INF/homePage/fragments/_object-card.jsp">
          <jsp:param name="nom" value="${item.nom}"/>
          <jsp:param name="prix" value="${item.prix}"/>
          <jsp:param name="finEnchere" value=/>
          <jsp:param name="vendeur" value="${item.utilisateur}"/>
        </jsp:include>
      </div>
    </c:forEach>
  </div>
</div>
