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
		
	      	<c:if test="${!empty listeCodesErreur}">
			<div class="alert alert-danger" role="alert">
			  <strong>Erreur!</strong>
			  <ul>
			  	<c:forEach var="code" items="${listeCodesErreur}">
			  		<li>${LecteurMessage.getMessageErreur(code)}</li>
			  	</c:forEach>
			  </ul>
			</div>
		</c:if>

		
		<div class="row d-flex justify-content-center">
			<form method="post" action="<%=request.getContextPath()%>/login">
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

			<!-- TODO : lien à mettre pour le mdp oublié -->
			<div>
				<a href="#">Mot de passe oublié</a>
			</div>
			<div>
				<input type="submit" value="Créer un compte" />
			</div>
		</div>
	</body>
</html>