<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="../fragments/_bootstrap_import.jsp"/>
<title>Mon profil</title>
</head>
<body>

<h1>Mon profil</h1>

		<!-- TODO: remplir le path de l'action vers la liste des enchères -->
		<form method="post" action="#">
			<label>Pseudo :</label><input type="text" id="pseudo "name="pseudo"/>
			<label> Nom :</label><input type="text" id="nom" name="nom"/>
			<br>
			<label> Prénom :</label><input type="text" id="prenom" name="prenom"/>
			<label> Email :</label><input type="email" id="email" name="email"/>
			<br>
			<label> Téléphone :</label><input type="tel" id="telephone" name="telephone" />
			<label> Rue :</label><input type="text" id="rue" name="rue"/>
			<br>
			<label> Code Postal :</label><input type="text" id="codePostal" name="codePostal"/>
			<label> Ville :</label><input type="text" id="ville" name="ville"/>
			<br>
			<label> Mot de passe :</label><input type="password" id="motDePasse" name="motDePasse"/>
			<label> Confirmation :</label><input type="password" id="confirmationMotDePasse" name="confirmationMotDePasse"/>
			<input type="submit" value="Créer"/>
		</form>
		
		<br>
		
		<form method="post" action="<%=request.getContextPath()%>/home">
			<button class="shadow__btn">Annuler</button>
		</form>
		
		





</body>
</html>