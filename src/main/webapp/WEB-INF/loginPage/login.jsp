<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<jsp:include page="/WEB-INF/fragments/_normalize-import.jsp"/>
		<link rel="stylesheet" href="<c:url value="/css/shared/header.css"/>"/>
		<link rel="stylesheet" href="<c:url value="/css/login/login-form.css"/> "/>
		<link rel="stylesheet" href="<c:url value="/css/fragments/_errors/errors.css"/> "/>
		<title>Connexion</title>
	</head>
	<body>
	<div class="container">
		<jsp:include page="/WEB-INF/fragments/_fullHeader.jsp"/>
		<jsp:include page="/WEB-INF/fragments/_error-messages.jsp"/>
		<div class="container-main">
			<form method="post" action="<c:url value="/login"/>">
				<div class="label-field">
					<label for="identifiant"> Identifiant :</label>
					<input type="text" id="identifiant" name="identifiant" />
				</div>
				<div class="label-field">
					<label for="mdp">Mot de passe :</label>
					<input type="password" id="mdp" name="mdp"/>
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
				<a href=<c:url value="/profil"/>>
					<button>Créer un compte</button>
				</a>
			</div>
		</div>
	</div>
</body>
</html>