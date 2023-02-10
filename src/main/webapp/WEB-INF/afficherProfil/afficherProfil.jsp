<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Profil</title>
<link rel="stylesheet" href="<c:url value="/css/shared/header.css"/>">
<link rel="stylesheet" href="<c:url value="/css/afficherprofil/afficherprofil.css"/> ">
<jsp:include page="/WEB-INF/fragments/_normalize-import.jsp" />
	<jsp:useBean id="user" type="fr.eni.ecole.encheres.bo.Utilisateur" scope="request"/>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/fragments/_fullHeader.jsp"/>
		<div class="body-container">
			<div class="fields-container">
				<div><p>Pseudo : </p><h3>${user.pseudo}</h3></div>
				<div><p>Nom : </p><p>${user.nom}</p></div>
				<div><p>Prenom : </p><p>${user.prenom}</p></div>
				<div><p>Email : </p><p>${user.email}</p></div>
				<div><p>Télephone : </p><p>${user.telephone}</p></div>
				<div><p>Rue : </p><p>${user.rue}</p></div>
				<div><p>Ville : </p><p>${user.ville}</p></div>
				<div><p>Crédits :</p><p>${user.credit}</p></div>
			</div>
			<c:if test="${!empty sessionScope.user.noUtilisateur && sessionScope.user.noUtilisateur eq requestScope.user.noUtilisateur}">
				<div class="btn"><a href=<c:url value="/profil/modifier"/>><button class="button" id="modifierProfil">Modifier</button></a></div>
			</c:if>
		</div>
	</div>
</body>
</html>