<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/css/shared/header.css"/>">
<link rel="stylesheet" href="<c:url value="/css/ajoutArticle/ajoutArticle.css"/> ">
<jsp:include page="/WEB-INF/fragments/_normalize-import.jsp" />
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
	<div class="formulaire"> 
		<div>
			<label for="Article">Article</label>
			<input type="text" id="nomArticle" name="nomArticle" />
		</div>
		<div>
			<label for="Description">Description</label>
			<input type="text" id="description" name="description" />
		</div> 
	    <div>
		    <label for="categories">Catégorie : </label>
			<select name="selectedCategory">
				<c:forEach var="categorie" items="${requestScope.categories}">
					<option>${categorie.libelle}</option>
				</c:forEach>
	  	</select>
	  	</div> 
		<div>
			<label for="photoArticle">Photo de l'article</label>
			<input type="file" value="UPLOADER" name="photoArticle">
		</div>
	    <div>
	    <label for="miseAPrix">Mise à prix :</label>
		<input type="number" value="prix" id="miseAPrix" name="miseAPrix" />
		</div>
		<div>
		<label for="debutEnchere">Début de l'Enchère</label>
		<input type="datetime-local" id="dateDebutEncheres" name="dateDebutEncheres" />
		</div>
	    <div>
	    <label for="finEnchere">Fin de l'Enchère</label>
	    <input type="datetime-local" id="dateFinEncheres" name="dateFinEncheres" />
	    </div>
	    <div class="RTR">
		    <fieldset>
				<legend>Retrait</legend>
				<div>
					<label for="rue">Rue : </label>
					<input type="text" id="rue" name="rue" value=" ${sessionScope.user.rue}"/>
				</div>
		     	<div>
			     	<label for="codePostal">CodePostal : </label>
			       	<input type="text" id="codePostal" name="codePostal" value=" ${sessionScope.user.codePostal}"/>
		       	</div>
		      	<div>
			      	<label for="ville">Ville : </label>
			      	<input type="text" id="ville" name="ville" value=" ${sessionScope.user.ville}" />
		      	</div>
			</fieldset>
		</div>
	</div>
	<div class="btn">
	    <input type="submit" name="Enregistrer"> 
        <input type="button" name="Annuler" />
        <input type="button" name="Annuler la vente" />
    </div>    
  </form>
 </div>
</body>
</html>