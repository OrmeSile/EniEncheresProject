<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/css/shared/header.css"/>">
<link rel="stylesheet" href="<c:url value="/css/modifierProfil/modifierProfil.css"/> ">
<jsp:include page="/WEB-INF/fragments/_normalize-import.jsp" />
<title>Mon profil</title>
</head>
<body>
	<div class="container">
		<header class="row navbar navbar-expand-md bg-body-tertiary">
			<jsp:include page="/WEB-INF/fragments/_header.jsp" />
		</header>
		<h1>Mon profil</h1>
		<form method="post" action=<c:url value="/"/>>
			<input type="hidden" value="${sessionScope.user.noUtilisateur}">
			<div class="label-field">
				<label for="pseudo">Pseudo :</label>
				<input type="text" id="pseudo" name="pseudo" value="${sessionScope.user.pseudo}"/>
			</div>
			<div class="label-field">
				<label for="nom"> Nom :</label>
				<input type="text" id="nom" name="nom" value="${sessionScope.user.nom}"/>
			</div>
			<div class="label-field">
				<label for="prenom"> Prénom :</label>
				<input type="text" id="prenom" name="prenom" value="${sessionScope.user.prenom}"/>
			</div>
			<div class="label-field">
				<label for="email"> Email :</label>
				<input type="email" id="email" name="email" value="${sessionScope.user.email}"/>
			</div>
			<div class="label-field">
				<label for="telephone"> Téléphone :</label>
				<input type="tel" id="telephone" name="telephone" value="${sessionScope.user.telephone}" />
			</div>
			<div class="label-field">
			<label for="rue"> Rue :</label>
				<input type="text" id="rue" name="rue" value="${sessionScope.user.rue}"/>
			</div>
			<div class="label-field">
				<label for="codePostal"> Code Postal :</label>
				<input type="text" id="codePostal" name="codePostal" value="${sessionScope.user.codePostal}"/>
			</div>
			<div class="label-field">
				<label for="ville"> Ville :</label>
				<input type="text" id="ville" name="ville" value="${sessionScope.user.ville}"/>
			</div>
			<c:if test="${!empty sessionScope.utilisateur}">
			<div class="label-field">
				<label for="motDePasseActuel"> Mot de passe actuel :</label>
				<input type="password" id="motDePasseActuel" name="motDePasseActuel" value="${sessionScope.user.motDePasse}"/>
			</div>
			</c:if>
			<div class="label-field">
				<label for="motDePasse"> Mot de passe :</label>
				<input type="password" id="motDePasse" name="motDePasse"/>
			</div>
			<div class="label-field">
				<label for="confirmationMotDePasse"> Confirmation :</label>
				<input type="password" id="confirmationMotDePasse" name="confirmationMotDePasse"/>
			</div>
		</form>
		<c:choose>
			<c:when test="${!empty sessionScope.utilisateur}">
				<input type="submit" value="Enregistrer"/>
				<a href=${pageContext.request.contextPath}><button>Supprimer mon compte</button></a>
			</c:when>
			<c:otherwise>
				<input type="submit" value="Créer"/>
				<a href=${pageContext.request.contextPath}><button>Annuler</button></a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>