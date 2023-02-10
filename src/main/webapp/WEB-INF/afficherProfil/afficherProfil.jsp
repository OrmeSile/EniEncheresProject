<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Profil</title>
<link rel="stylesheet" href="<c:url value="/css/shared/header.css"/>">
<link rel="stylesheet" href="<c:url value="/css/afficherprofil/afficherprofil.css"/> ">
<jsp:include page="/WEB-INF/fragments/_normalize-import.jsp" />
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/fragments/_fullHeader.jsp"/>
		<div class="body-container">
			<div class="fields-container">
				<div><p>Pseudo : </p><h3>${requestScope.user.pseudo}</h3></div>
				<div><p>Nom : </p><p>${requestScope.user.nom}</p></div>
				<div><p>Prenom : </p><p>${requestScope.user.prenom}</p></div>
				<div><p>Email : </p><p>${requestScope.user.email}</p></div>
				<div><p>Télephone : </p><p>${requestScope.user.telephone}</p></div>
				<div><p>Rue : </p><p>${requestScope.user.rue}</p></div>
				<div><p>Ville : </p><p>${requestScope.user.ville}</p></div>
			</div>
			<c:if test="${!empty sessionScope.user.noUtilisateur && sessionScope.user.noUtilisateur eq requestScope.user.noUtilisateur}">
				<div class="btn"><a href=<c:url value="/profil/modifier"/>><button class="button" id="modifierProfil">Modifier</button></a></div>
			</c:if>
		</div>
	</div>
</body>
</html>