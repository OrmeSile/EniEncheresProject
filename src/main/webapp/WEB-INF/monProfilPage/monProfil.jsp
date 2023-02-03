<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/fragments/_bootstrap-import.jsp" />
<title>Mon profil</title>
</head>
<body>
	<div class="container">
	
		<header class="row navbar navbar-expand-md bg-body-tertiary">
			<jsp:include page="/WEB-INF/fragments/_header.jsp" />
		</header>

		<h1 align="center">Mon profil</h1>

				<!-- TODO: remplir le path de l'action vers la liste des enchères -->
				<form method="post" action="${pageContext.request.contextPath}">
					<label for="pseudo">Pseudo :</label><input type="text" id="pseudo" name="pseudo"/>
					<label for="nom"> Nom :</label><input type="text" id="nom" name="nom"/>
					<br>
					<label for="prenom"> Prénom :</label><input type="text" id="prenom" name="prenom"/>
					<label for="email"> Email :</label><input type="email" id="email" name="email"/>
					<br>
					<label for="telephone"> Téléphone :</label><input type="tel" id="telephone" name="telephone" />
					<label for="rue"> Rue :</label><input type="text" id="rue" name="rue"/>
					<br>
					<label for="codePostal"> Code Postal :</label><input type="text" id="codePostal" name="codePostal"/>
					<label for="ville"> Ville :</label><input type="text" id="ville" name="ville"/>
					<br>
					<c:if test="${!empty sessionScope.utilisateur}">
					<label for="motDePasseActuel"> Mot de passe actuel :</label><input type="password" id="motDePasseActuel" name="motDePasseActuel"/>
					</c:if>
					<br>
					<label for="motDePasse"> Mot de passe :</label><input type="password" id="motDePasse" name="motDePasse"/>
					<label for="confirmationMotDePasse"> Confirmation :</label><input type="password" id="confirmationMotDePasse" name="confirmationMotDePasse"/>
				</form>
				<c:choose>
						<c:when test="${!empty sessionScope.utilisateur}">
						<input type="submit" value="Enregistrer"/>
						<a href=${pageContext.request.contextPath}><button class="shadow__btn">Supprimer mon compte</button></a>
						</c:when>
						<c:otherwise>
						<input type="submit" value="Créer"/>
						<a href=${pageContext.request.contextPath}><button class="shadow__btn">Annuler</button></a>
						</c:otherwise>
					</c:choose>

		<br>
		
			
	</div>
</body>
</html>