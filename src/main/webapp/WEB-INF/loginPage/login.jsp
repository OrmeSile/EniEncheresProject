<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>

	<jsp:include page="/WEB-INF/fragments/_header.jsp"/>

		<form method="post" action="<%=request.getContextPath()%>/Login">
			<label> Identifiant :</label><input type="text" name="identifiant" />
			<br>
			<label> Mot de passe :</label><input type="password" name="mdp" /> 
			<input type="submit" value="Connexion" />
		</form>

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
		
		
		
		
		
</body>
</html>