<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>test DAL</title>
</head>
<body>
<c:forEach var="error" items="${requestScope.errors}">
  <p>${error}</p>
</c:forEach>
<p>User : ${requestScope.user.pseudo}</p>
<c:forEach var="article" items="${requestScope.articles}">
  <p>Article :</p>
  <ul>
    <li>${article.nomArticle}</li>
    <li>${article.description}</li>
  </ul>
</c:forEach>
</body>
</html>
