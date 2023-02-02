<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/fragments/_bootstrap-import.jsp"/>
  <title>Title</title>
</head>
<body>
<div class="container-fluid">
  <div class="col-sm-6 col-lg-4">
    <div class="row">
      <div class="col-sm-6">
        <jsp:include page="/WEB-INF/fragments/_object-Card.jsp">
          <jsp:param name="nom" value="nomParDefaut"/>
          <jsp:param name="prix" value="1234"/>
          <jsp:param name="finEnchere" value="25/25/2515"/>
          <jsp:param name="vendeur" value="vendeur"/>
        </jsp:include>
      </div>
      <div class="col-sm-6">
        <jsp:include page="/WEB-INF/fragments/_object-Card.jsp">
          <jsp:param name="nom" value="nomParDefaut"/>
          <jsp:param name="prix" value="1234"/>
          <jsp:param name="finEnchere" value="25/25/2515"/>
          <jsp:param name="vendeur" value="vendeur"/>
        </jsp:include>
      </div>
    </div>
  </div>


  <jsp:include page="/WEB-INF/fragments/_object-Card.jsp">
    <jsp:param name="nom" value="nomParDefaut"/>
    <jsp:param name="prix" value="1234"/>
    <jsp:param name="finEnchere" value="25/25/2515"/>
    <jsp:param name="vendeur" value="vendeur"/>
  </jsp:include>
  <jsp:include page="/WEB-INF/fragments/_object-Card.jsp">
    <jsp:param name="nom" value="nomParDefaut"/>
    <jsp:param name="prix" value="1234"/>
    <jsp:param name="finEnchere" value="25/25/2515"/>
    <jsp:param name="vendeur" value="vendeur"/>
  </jsp:include>
</div>
</body>
</html>
