<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="<c:url value="/css/shared/header.css"/>">
  <link rel="stylesheet" href="<c:url value="/css/fragments/_errors/errors.css"/>">
</head>
<body>
  <header class="navbar">
    <jsp:include page="/WEB-INF/fragments/_header.jsp"/>
  </header>
<jsp:include page="/WEB-INF/fragments/_error-messages.jsp"/>
</body>
<div>
  <div class="main-container">
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eos, et necessitatibus neque nesciunt repudiandae temporibus vero. Consequatur, debitis dolore dolorum eos illum iure natus rem tempora tempore veritatis? Aspernatur, sequi.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores, ipsum, quam? Architecto beatae blanditiis commodi, cupiditate error explicabo fugiat iure, nam nobis perferendis, sequi velit. Alias beatae deleniti doloremque neque!</p>
  </div>
  <a href="<c:url value="/TestServletErrorDisplay"/>">refresh</a>
</div>
</html>
