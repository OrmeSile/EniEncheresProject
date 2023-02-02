<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/fragments/_bootstrap-import.jsp"/>
  <title>Title</title>
</head>
<body>
<div class="container-fluid">
  <div class="col-sm-6">
    <jsp:include page="/WEB-INF/homePage/fragments/_object-card.jsp">
      <jsp:param name="nom" value="nom"/>
      <jsp:param name="prix" value="prix"/>
      <jsp:param name="finEnchere" value="finEnchere"/>
      <jsp:param name="vendeur" value="vendeur"/>
    </jsp:include>
  </div>
</div>
</body>
</html>
