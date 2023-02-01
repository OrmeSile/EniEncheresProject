<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <jsp:include page="/WEB-INF/fragments/_bootstrap_import.jsp"/>
  <title>Page d'accueil</title>
</head>
<body>
<div class="container">
  <header class="row navbar navbar-expand-md bg-dark-subtle d-flex align-content-between">
    <div class="col-2">
      <jsp:include page="/WEB-INF/fragments/_header.jsp"/>
    </div>
    <div class="col-3">
      <a class="col-2" href="${pageContext.request.contextPath}/login">S'inscrire/Se connecter</a>
    </div>
  </header>
//TODO js filter for names ?


</div>
</body>
</html>
