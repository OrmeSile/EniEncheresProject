<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Profil</title>
<jsp:include page="/WEB-INF/fragments/_bootstrap-import.jsp" />
</head>
<body>
	<div class="container-fluid">
		<header
			class="row navbar navbar-expand-md bg-dark-subtle d-flex align-content-between">
			<div class="col-2">
				<jsp:include page="/WEB-INF/fragments/_header.jsp" />
			</div>
		</header>
		<h3>${requestScope.user.pseudo}</h3>
		<p>${requestScope.user.nom}</p>
		<p>${requestScope.user.prenom}</p>
		<p>${requestScope.user.email}</p>
		<p>${requestScope.user.telephone}</p>
		<p>${requestScope.user.rue}</p>
		<p>${requestScope.user.ville}</p>
		<p>${requestScope.user.credit}</p>
		<c:if test="${!empty sessionScope.user.noUtilisateur && sessionScope.user.noUtilisateur eq requestScope.user.noUtilisateur}">
			<a href=<c:url value="/profil/modifier"/>><button class="button" id="modifierProfil">Modifier</button></a>
		</c:if>
	</div>
</body>
</html>