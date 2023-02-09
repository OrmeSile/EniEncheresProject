<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<jsp:useBean id="date" scope="request" type="java.time.LocalDateTime"/>
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
	
	<header class="row navbar navbar-expand-md bg-body-tertiary">
		<jsp:include page="/WEB-INF/fragments/_header.jsp" />
  	</header>
  	<div class="container">
	<h1 align="center">Nouvelle Vente</h1>
	<form method="post" action=<c:url value="/AjoutArticle"/>>
	<div class="formulaire"> 
		<div>
			<label for="nom-article">Article</label>
			<input type="text" id="nom-article" name="nom-article" />
		</div>
		<div>
			<label for="description">Description</label>
			<input type="text" id="description" name="description" />
		</div> 
	    <div>
		    <label for="selectedCategory">Catégorie : </label>
			<select id="selectedCategory" name="selectedCategory">
				<c:forEach var="categorie" items="${requestScope.categories}">
					<option>${categorie.libelle}</option>
				</c:forEach>
	  	</select>
	  	</div> 
		<div>
			<label for="photo-article">Photo de l'article</label>
			<input type="file" value="UPLOADER" id="photo-article" name="photo-article">
		</div>
	    <div>
	    <label for="mise-a-prix">Mise à prix :</label>
		<input type="number" value="prix" id="mise-a-prix" name="mise-a-prix" />
		</div>
		<div>
		<label for="debut-enchere">Début de l'Enchère</label>
		<input type="datetime-local" id="debut-enchere" name="debut-enchere" />
		</div>
	    <div>
	    <label for="fin-enchere">Fin de l'Enchère</label>
	    <input type="datetime-local" id="fin-enchere" name="fin-enchere" />
	    </div>
	    <div class="RTR">
		    <fieldset>
				<legend>Retrait</legend>
				<div>
					<label for="rue">Rue : </label>
					<input type="text" id="rue" name="rue" value=" ${sessionScope.user.rue}"/>
				</div>
		     	<div>
			     	<label for="code-postal">CodePostal : </label>
			       	<input type="text" id="code-postal" name="code-postal" value=" ${sessionScope.user.codePostal}"/>
		       	</div>
		      	<div>
			      	<label for="ville">Ville : </label>
			      	<input type="text" id="ville" name="ville" value=" ${sessionScope.user.ville}" />
		      	</div>
			</fieldset>
		</div>
	</div>
	<div class="btn-container">		
	     <div><input type="submit" name="enregistrer" value="Enregistrer"></div> 
         <div><a href="<c:url value="/"/>"><input type="button" name="annuler" value="Annuler" /></a></div>
         <div>
         <c:if test="${ requestScope.article.vendeur.noUtilisateur == sessionScope.user.noUtilisateur && requestScope.article.dateDebutEnchere.isAfter(date)}">
         	<input type="button" name="annuler-la-vente" value="Annuler la vente" />
		</c:if>         
         </div>
    </div>   
  </form>
 </div>
</body>
</html>