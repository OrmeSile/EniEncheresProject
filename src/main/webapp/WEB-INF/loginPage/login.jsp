<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<jsp:include page="/WEB-INF/fragments/_normalize-import.jsp"/>
		<link rel="stylesheet" href="<c:url value="/css/shared/header.css"/>">
		<link rel="stylesheet" href="<c:url value="/css/login/login-form.css"/> ">
		<title>Connexion</title>
	</head>
	<body>
	<div class="container">
		<header class="navbar">
			<jsp:include page="/WEB-INF/fragments/_header.jsp" />
		</header>
		<div class="container-main">
		<c:if test="${!empty sessionScope.errors}">
			<div class="error" role="alert">
				<strong>Erreur!</strong>
				<ul>
					<c:forEach var="message" items="${sessionScope.errors}">
						<li>${message}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
			<form method="post" action="<c:url value="/login"/>">
				<div class="label-field">
					<label for="identifiant"> Identifiant :</label>
					<input type="text" id="identifiant" name="identifiant" />
				</div>
				<div class="label-field">
					<label for="mdp">Mot de passe :</label>
					<input type="password" id="mdp" name="mdp" />
				</div>
				<div class="form-submit-block">
					<input type="submit" value="Connexion" />
					<div class="form-misc">
						<div class="form-persist">
							<input type="checkbox" name="persist" id="persist">
							<label for="persist">Se souvenir de moi</label>
						</div>
						<a href="#">Mot de passe oublié</a>
					</div>
				</div>
			</form>
			<div class="register">
				<a href=<c:url value="/monProfil"/>>
					<button class="shadow__btn">Créer un compte</button>
				</a>
			</div>
		</div>
	</div>
</body>
</html>