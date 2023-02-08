<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout Article</title>
</head>
<body>
	<div class="container">
	<header class="row navbar navbar-expand-md bg-body-tertiary">
		<jsp:include page="/WEB-INF/fragments/_header.jsp" />
  	</header>
	<h1 align="center">Nouvelle Vente</h1>
	<form method="post" action=<c:url value="/AjoutArticle"/>>
		<label for="Article">Article</label>
		<input type="text" id="nomArticle" name="nomArticle" />
		<label for="Description">Description</label>
		<input type="text" id="description" name="description" /> 
	    <label for="categories">Catégorie : </label>
		<select name="selectedCategory">
			<c:forEach var="categorie" items="${requestScope.categories}">
				<option>${categorie.libelle}</option>
			</c:forEach>
	  	</select> 
		<label for="photoArticle">Photo de l'article</label>
		<input type="file" value="UPLOADER" name="photoArticle">
	    <label for="miseAPrix">Mise à prix :</label>
		<input type="number" value="prix" id="miseAPrix" name="miseAPrix" />
		<label for="debutEnchere">Début de l'Enchère</label>
		<input type="datetime-local" id="dateDebutEncheres" name="dateDebutEncheres" />
	    <label for="finEnchere">Fin de l'Enchère</label>
	    <input type="datetime-local" id="dateFinEncheres" name="dateFinEncheres" />
	    <fieldset>
			<legend>Retrait</legend>
			<label for="rue">Rue : </label>
			<input type="text" id="rue" name="rue" value=" ${sessionScope.user.rue}"/>
	     	<label for="codePostal">CodePostal : </label>
	       	<input type="text" id="codePostal" name="codePostal" value=" ${sessionScope.user.codePostal}"/>
	      	<label for="ville">Ville : </label>
	      	<input type="text" id="ville" name="ville" value=" ${sessionScope.user.ville}" />
		</fieldset>
	    <input type="submit" name="Enregistrer"> 
        <input type="button" name="Annuler" />
        <input type="button" name="Annuler la vente" />
  </form>
 </div>
</body>
</html>