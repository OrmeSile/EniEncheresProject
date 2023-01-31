<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<jsp:include page="../fragments/_bootstrap_import.jsp"/>
		<title>Connexion</title>
	</head>
	<body>
	<div class="container">
		<div class="row">
			<jsp:include page="/WEB-INF/fragments/_header.jsp"/>
		</div>
		<div class="row d-flex justify-content-center">
			<form method="post" action="<%=request.getContextPath()%>/Login">
					<label for="identifiant"> Identifiant :</label>
					<input type="text" id ="identifiant" name="identifiant" />
				<br>
				<label for="mdp"> Mot de passe :</label>
				<input type="password" id="mdp" name="mdp" />
				<input type="submit" value="Connexion" />
			</form>
		</div>
			<div>
				<label>Se souvenir de moi<input type="checkbox" name="seSouvenir"></label>
			</div>

			<!-- TODO : lien � mettre pour le mdp oubli� -->
			<div>
				<a href="#">Mot de passe oubli�</a>
			</div>
			<div>
				<input type="submit" value="Cr�er un compte" />
			</div>
		</div>
	</body>
</html>