<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<jsp:include page="/WEB-INF/fragments/_bootstrap-import.jsp"/>
		<title>Connexion</title>
	</head>
	<body>
	<div class="container">
		<header class="row navbar navbar-expand-md bg-body-tertiary">
			<jsp:include page="/WEB-INF/fragments/_brand.jsp" />
		</header>
		<c:if test="${!empty listeCodesErreur}">
			<div class="alert alert-danger" role="alert">
				<strong>Erreur!</strong>
				<ul>
					<c:forEach var="message" items="${listeCodesErreur}">
						<li>${message}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<div class="row d-flex justify-content-center">
			<form method="post" action="<%=request.getContextPath()%>/login">
				<label for="identifiant"> Identifiant :</label> <input type="text"
					id="identifiant" name="identifiant" /> <br> <label for="mdp">
					Mot de passe :</label> <input type="password" id="mdp" name="mdp" /> <input
					type="submit" value="Connexion" />
			</form>
		</div>
		<div>
			<label>Se souvenir de moi<input type="checkbox"
				name="seSouvenir"></label>
		</div>

		<!-- TODO : lien Ã  mettre pour le mdp oubliÃ© -->
		<div>
			<a href="#">Mot de passe oublié</a>
		</div>
		<div>
			<a href=${pageContext.request.contextPath}/monProfil><button class="shadow__btn">Créer un compte</button></a>
		</div>
	</div>
</body>
</html>